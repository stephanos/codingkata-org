package org.codingkata.unit.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.IKataSolution;
import org.codingkata.unit.api.IKataSolution.ACTION;
import org.codingkata.unit.api.IKataSolution.Animal;
import org.codingkata.unit.api.IKataSolution.ITEM;
import org.codingkata.unit.api.IKataSolution.ORIENTATION;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask implements IKataTask {

    /* ==== FIELDS ==== */

    private IKataSolution m_solution;
    private int trainingIterations;
    private KataUI ui;
    private int max_row, max_col;
    private ITEM[][] fields;
    private AnimalWrap[] animals;
    private Plant[] plants;
    private int[] points;
    private int msPause = 1;

    /* ==== PUBLIC ==== */

    public void start() {
        initGame();
        trainingIterations = Math.min(Math.max(100, m_solution.countOfGenerations()), 10000);
        points = new int[trainingIterations + 1];
        for (int i = 0; i < trainingIterations; i++) {
            if ((i == trainingIterations - 1)) {
                ui.setVisible(m_solution.visualizeLastGeneration());
            }
            evolve();
            evaluate(i + 1);
        }
        ui.dispose();
        summary();
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }

    /* ==== PRIVATE ==== */

    private void initGame() {
        max_row = 15;
        max_col = 15;
        fields = new ITEM[max_row][max_col];
        ui = new KataUI("Evolution Kata: Visualization",
                max_row * 30, max_col * 30, max_row, max_col);
    }

    private void evaluate(int generation) {
        int total = 0;
        String each = "";
        for (AnimalWrap a : animals) {
            a.animal.points = a.food;
            total += a.food;
            each += a.food + " ";
        }
        points[generation] = total;
        if (generation == trainingIterations - 4) {
            System.out.println(" -- BEST OF 5 BEGINS --");
        }
        System.out.println(generation + ". generation: " + total + " points { " + each + "}");
    }

    private void evolve() {
        initIteration();
        simulate();
    }

    private void initIteration() {
        clearField();
        initAnimals();
        initPlants();
    }

    private void clearField() {
        for (int i = 0; i < max_row; i++) {
            for (int j = 0; j < max_col; j++) {
                fields[i][j] = ITEM.EMPTY;
            }
        }
    }

    private void initAnimals() {
        Animal[] as = m_solution.createGeneration(4, getGeneration());
        animals = new AnimalWrap[4];
        for (int i = 0; i < 4; i++) {
            AnimalWrap aw = new AnimalWrap();
            aw.animal = as[i];
            animals[i] = aw;
        }
        placeAnimal(animals[0], 0, 0, ORIENTATION.RIGHT);
        placeAnimal(animals[1], 0, max_col - 1, ORIENTATION.DOWN);
        placeAnimal(animals[2], max_row - 1, max_col - 1, ORIENTATION.LEFT);
        placeAnimal(animals[3], max_row - 1, 0, ORIENTATION.UP);
    }

    private Animal[] getGeneration() {
        if (animals == null) {
            return null;
        } else {
            Animal[] res = new Animal[animals.length];
            for (int i = 0; i < animals.length; i++) {
                res[i] = animals[i].animal;
            }
            return res;
        }
    }

    private void initPlants() {

        int maxPlantRows = (max_row - 1) / 2;
        plants = new Plant[maxPlantRows * max_col - 4];

        int p = 0;
        int plantRows = 0;
        int curRow = 1;
        int lastPlanted = 0;
        List<Integer> takenRows = new ArrayList<Integer>(maxPlantRows);

        while (true) {
            if (!takenRows.contains(curRow)) {
                lastPlanted = 0;
                if (new Random().nextBoolean() && lastPlanted <= 1) {
                    for (int j = 2; j < max_col - 2; j++) {
                        p++;
                        Plant plant = new Plant();
                        plant.row = curRow;
                        plant.col = j;
                        placeItem(curRow, j, ITEM.PLANT);
                        if (new Random().nextInt(10) > 8) {
                            plant.daysSinceEaten = new Random().nextInt(10);
                        }
                        plants[p] = plant;
                    }
                    takenRows.add(curRow);
                    plantRows++;
                    lastPlanted++;
                }
            } else {
                lastPlanted++;
            }
            if (plantRows == maxPlantRows) {
                break;
            }
            curRow = Math.max(1, (curRow + 1) % max_row);
        }
    }

    private void placeAnimal(AnimalWrap a, int row, int col, ORIENTATION orient) {
        a.col = col;
        a.row = row;
        a.orientation = orient;
        placeItem(row, col, ITEM.ANIMAL);
    }

    private void placeItem(int row, int col, ITEM view) {
        fields[row][col] = view;
    }

    private void simulate() {
        for (int i = 1; i < 365; i++) {
            ui.pause(msPause);
            for (AnimalWrap a : animals) {
                ITEM inFront = ITEM.END;
                int dx = a.orientation == ORIENTATION.RIGHT ? 1
                        : (a.orientation == ORIENTATION.LEFT ? -1 : 0);
                int dy = a.orientation == ORIENTATION.DOWN ? 1
                        : (a.orientation == ORIENTATION.UP ? -1 : 0);
                int newPosX = a.col + dx;
                int newPosY = a.row + dy;
                if (dx != 0) {
                    if (newPosX >= 0 && newPosX < max_col) {
                        inFront = fields[a.row][newPosX];
                    }
                } else if (dy != 0) {
                    if (newPosY >= 0 && newPosY < max_row) {
                        inFront = fields[newPosY][a.col];
                    }
                }
                ACTION act = a.animal.react(a.orientation, inFront);
                if (act == ACTION.FORWARD) {
                    if (inFront == ITEM.EMPTY || inFront == ITEM.PLANT) {
                        if (inFront == ITEM.PLANT) {
                            a.food++;
                            for (Plant p : plants) {
                                if (p != null && p.col == newPosX && p.row == newPosY) {
                                    p.daysSinceEaten = 1;
                                    break;
                                }
                            }
                        }
                        placeItem(a.row, a.col, ITEM.EMPTY);
                        placeItem(newPosY, newPosX, ITEM.ANIMAL);
                        a.row = newPosY;
                        a.col = newPosX;
                    }
                } else if (act == ACTION.TURN_LEFT) {
                    a.orientation = a.orientation.moveLeft();
                } else if (act == ACTION.TURN_RIGHT) {
                    a.orientation = a.orientation.moveRight();
                }
            }
            ui.refresh(animals, plants);
            for (Plant p : plants) {
                if (p != null) {
                    if (fields[p.row][p.col] == ITEM.EMPTY) {
                        if (p.daysSinceEaten == 10) {
                            p.daysSinceEaten = -1;
                            placeItem(p.row, p.col, ITEM.PLANT);
                        } else if (p.daysSinceEaten > -1) {
                            p.daysSinceEaten++;
                        }
                    }
                }
            }
        }
    }

    private void summary() {

        // find best
        int best = 0;
        for (int i = 0; i < 5; i++) {
            if (points[trainingIterations - i] > best) {
                best = points[trainingIterations - i];
            }
        }

        // put points into result
        getResult().setPoints (best);

        // print
        optimized("YOUR FINAL SCORE IS '" + best
                + "' (with " + trainingIterations + " generations)");
    }
}
