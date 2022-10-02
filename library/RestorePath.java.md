---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord.java
    title: library/BellmanFord.java
  - icon: ':question:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/Dijkstra_pathEdge_test.java
    title: library/Dijkstra_pathEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_path_test.java
    title: library/Dijkstra_path_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':question:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/RestorePath.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nfinal class RestorePath {\n\tpublic static final int[]\
    \ path(final int[] prv, final int start, int goal) { // O(V)\n\t\tSimpleUtil.rangeCheck(start,\
    \ prv.length);\n\t\tSimpleUtil.rangeCheck(goal, prv.length);\n\t\tfinal Deque<Integer>\
    \ pathList = new ArrayDeque<>();\n\t\tpathList.addLast(goal);\n\t\twhile(goal\
    \ != start) pathList.addLast(goal = prv[goal]);\n\t\tfinal int path[] = new int[pathList.size()];\n\
    \t\tfor(int i = 0; i < path.length; i ++) path[i] = pathList.removeLast();\n\t\
    \treturn path;\n\t}\n\t@SuppressWarnings(\"unchecked\")\n\tpublic static final\
    \ <Edge extends AbstractEdge<Edge>> Edge[] pathEdge(final int[] prv, final Edge[]\
    \ prvEdge, final int start, final int goal) {\n\t\tfinal int path[] = path(prv,\
    \ start, goal);\n\t\tfinal Edge pathEdge[] = (Edge[]) new Object[path.length -\
    \ 1];\n\t\tfor(int i = 1; i < path.length; i ++) pathEdge[i - 1] = prvEdge[path[i]];\n\
    \t\treturn pathEdge;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/RestorePath.java
  requiredBy:
  - library/BellmanFord.java
  - library/Dijkstra.java
  timestamp: '2022-10-02 16:35:54+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - library/Dijkstra_path_test.java
  - library/Dijkstra_pathEdge_test.java
documentation_of: library/RestorePath.java
layout: document
redirect_from:
- /library/library/RestorePath.java
- /library/library/RestorePath.java.html
title: library/RestorePath.java
---
