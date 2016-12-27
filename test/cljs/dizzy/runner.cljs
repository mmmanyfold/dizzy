(ns dizzy.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [dizzy.core-test]))

(doo-tests 'dizzy.core-test)
