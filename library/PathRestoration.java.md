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
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra.java
    title: library/TemplateDijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd.java
    title: library/WarshallFloyd.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_pathEdge_test.java
    title: library/Dijkstra_pathEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_path_test.java
    title: library/Dijkstra_path_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra_pathEdge_test.java
    title: library/TemplateDijkstra_pathEdge_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nfinal class PathRestoration {\n\tpublic static final\
    \ int[] path(final int[] prv, final int start, int goal) { // O(V)\n\t\tSimpleUtil.rangeCheck(start,\
    \ prv.length);\n\t\tSimpleUtil.rangeCheck(goal, prv.length);\n\t\tfinal Deque<Integer>\
    \ pathList = new ArrayDeque<>();\n\t\tpathList.addLast(goal);\n\t\twhile(goal\
    \ != start) pathList.addLast(goal = prv[goal]);\n\t\tfinal int path[] = new int[pathList.size()];\n\
    \t\tfor(int i = 0; i < path.length; i ++) path[i] = pathList.removeLast();\n\t\
    \treturn path;\n\t}\n\tpublic static final <Node extends AbstractNode<Edge>, Edge\
    \ extends AbstractEdge<Edge>> Node pathEdge(Node pathEdge, final int[] prv, final\
    \ Edge[] prvEdge, final int start, final int goal) {\n\t\tfinal int path[] = path(prv,\
    \ start, goal);\n\t\tfor(int i = 1; i < path.length; i ++) pathEdge.add(prvEdge[path[i]]);\n\
    \t\treturn pathEdge;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/PathRestoration.java
  requiredBy:
  - library/TemplateDijkstra.java
  - library/BellmanFord.java
  - library/WarshallFloyd.java
  - library/Dijkstra.java
  timestamp: '2022-10-03 17:15:22+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Dijkstra_path_test.java
  - library/Dijkstra_pathEdge_test.java
  - library/TemplateDijkstra_pathEdge_test.java
documentation_of: library/PathRestoration.java
layout: document
redirect_from:
- /library/library/PathRestoration.java
- /library/library/PathRestoration.java.html
title: library/PathRestoration.java
---
