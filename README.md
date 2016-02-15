# Project File Dependencies

Project managers, such as the UNIX utility make, are used to maintain large software projects made up from many components. Users write a project file specifying which components (called tasks) depend on others and the project manager can automatically update the components in the correct order.

Write a program that reads a project file from stdin and writes to stdout the order in which the tasks should be performed.

## Input Description

For simplicity we represent each task by an integer number from _1,2,3...N_ where _N_ is the total number of tasks. The first line of input _N_ specifies the number of tasks and the number _M_ of rules, such that _N<=100_ and _M<=100_.

The rest of the input consists of M rules, one in each line, specifying dependencies using the following syntax:

_T0 k T1 T2 T3 ... Tk_

This rule means that task number _T0_ depends on _k_ tasks _T1...Tk_ (we say that task _T0_ is the target and _T1...Tk_ are dependents).

Note that tasks numbers are separated by single spaces and that rules end with a newline. Rules can appear in any order, but each task can appear as target only once.

Your program can assume that there are no circular dependencies in the rules, i.e. no task depends directly or indirectly on itself.

## Output Description

The output should be a single line with the permutation of the tasks _1,2...N_ to be performed, ordered by dependencies (i.e. no task should appear before others that it depends on).

To avoid ambiguity in the output, tasks that do not depend on each other should be ordered by their number (lower numbers first).

## Example

__Input:__

__5 4__

__3 2 1 5__

__2 2 5 3__

__4 1 3__

__5 1 1__

__Output:__

__1 5 3 2 4__