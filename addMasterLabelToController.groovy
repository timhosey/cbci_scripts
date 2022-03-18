/*
  *** WARNING ***
  It is not recommended to EVER use the built-in node (on-controller executor).
  Always use an Agent!
*/
println "Adding 'master' label to Controller..."
println "This is not recommended. Don't use on-controller executors!"
def nodes = []
jenkins.model.Jenkins.instance.computers.each { c ->
  if (c.node.labelString.contains("built-in")) {
    if (c.node.labelString.contains("master")) {
      println "Controller already has this label. Skipping."
      println "Current string: " + c.node.labelString
    } else {
      c.node.labelString = c.node.labelString + " master"
      println "New string = " + c.node.labelString
    }
  }
}  