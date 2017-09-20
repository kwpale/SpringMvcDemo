# SpringMvcDemo
Just for my learning...

Settings for use in Intellij Idea

1. Check "Delegate IDE build/run actions to gradle"
1. Use explodedWar task for building exploded war
1. Add Tomcat
    - Add exploded artifact
    - Remove all "before launch: build" and add explodedWar task
    - On frame deactivation: Update classses and resources

---

Note that the `out` folder generated in Idea is just for making the resources able to hot-swapped.