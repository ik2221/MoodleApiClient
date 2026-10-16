#!/usr/bin/env bash

# Fork process & discard stderr stream
# To close the H2 jar process: close the GUI window
setsid --fork java -jar ~/.m2/repository/com/h2database/h2/2.5.250/h2-2.5.250.jar >/dev/null 2>&1

