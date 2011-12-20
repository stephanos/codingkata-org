require 'java'
java_package 'org.codingkata.unit'
java_import 'org.codingkata.unit.api.IKataSolution'

class MyKata
  java_implements IKataSolution

  java_signature 'String reply()'
  def reply
    "hello world"
  end

end