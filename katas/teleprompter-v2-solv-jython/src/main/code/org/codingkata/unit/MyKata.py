from org.codingkata.unit.api import BaseKataSolution;

class MyKata(BaseKataSolution):
    def translate(self, text, mapping):
        # My jython has no 're', else I'd use that...
        mapping = dict((str(key), str(value))
                       for key, value in mapping)
        bleeps = dict((str(key), "BLEEP")
                       for key, value in mapping.items())
        maps = (mapping, bleeps)

        text = text.split('"')

        for i, passage in enumerate(text):
            for key, value in maps[i % 2].items():
                passage = passage.replace(key, value)
            text[i] = passage

        return '"'.join(text)
