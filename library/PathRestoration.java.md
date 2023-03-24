---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_pathEdge_test.java
    title: library/Dijkstra_pathEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_path_test.java
    title: library/Dijkstra_path_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra_path_test.java
    title: library/TemplateDijkstra_path_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.FastIO;\nimport library.AbstractGraph;\n\
    \nfinal class PathRestoration {\n\tpublic static final int[] path(final int[]\
    \ prv, final int start, int goal) { // O(V)\n\t\tFastIO.rangeCheck(start, prv.length);\n\
    \t\tFastIO.rangeCheck(goal, prv.length);\n\t\tList<Integer> pathList = new ArrayList<>();\n\
    \t\tpathList.add(goal);\n\t\twhile(goal != start) pathList.add(goal = prv[goal]);\n\
    \t\tfinal int path[] = new int[pathList.size()];\n\t\tfor(int i = 0, j = path.length\
    \ - 1; i < path.length; i ++, j --) path[i] = pathList.get(j);\n\t\treturn path;\n\
    \t}\n\tpublic static final <Edge extends AbstractEdge<Edge>> List<Edge> pathEdge(final\
    \ int[] prv, final Edge[] prvEdge, final int start, final int goal) {\n\t\tint\
    \ path[] = path(prv, start, goal);\n\t\tList<Edge> pathEdge = new ArrayList<>(path.length);\n\
    \t\tfor(int i = 1; i < path.length; i ++) pathEdge.add(prvEdge[path[i]]);\n\t\t\
    return pathEdge;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/PathRestoration.java
  requiredBy: []
  timestamp: '2023-03-24 01:50:05+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Dijkstra_path_test.java
  - library/Dijkstra_pathEdge_test.java
  - library/TemplateDijkstra_path_test.java
documentation_of: library/PathRestoration.java
layout: document
redirect_from:
- /library/library/PathRestoration.java
- /library/library/PathRestoration.java.html
title: library/PathRestoration.java
---
