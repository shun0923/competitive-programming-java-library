---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  - icon: ':heavy_check_mark:'
    path: library/UnionFind.java
    title: library/UnionFind.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Kruskal_test.java
    title: library/Kruskal_test.java
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
    \ library.AbstractGraph;\nimport library.UnionFind;\n\nclass Kruskal {\n\tprivate\
    \ static UnionFind uf;\n\tprivate static ArrayWeightedNode used = new ArrayWeightedNode(-1);\n\
    \t// O(ElogV)\n\tpublic static final long cal(WeightedGraph g) { return cal(g.numNode,\
    \ g.edges()); }\n\tpublic static final long cal(int numNode, WeightedNode edges)\
    \ {\n\t\tuf = new UnionFind(numNode);\n\t\tused.clear();\n\t\tQueue<WeightedEdge>\
    \ pq = new PriorityQueue<WeightedEdge>();\n\t\tfor(WeightedEdge e : edges) if(!SimpleUtil.isINF(e.cost))\
    \ pq.add(e);\n\n\t\tlong cost = 0;\n\t\twhile(!pq.isEmpty()) {\n\t\t\tWeightedEdge\
    \ e = pq.poll();\n\t\t\tif(!uf.same(e.source, e.target)) {\n\t\t\t\tcost += e.cost;\n\
    \t\t\t\tuf.unite(e);\n\t\t\t\tused.add(e);\n\t\t\t}\n\t\t}\n\t\treturn cost;\n\
    \t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/UnionFind.java
  isVerificationFile: false
  path: library/Kruskal.java
  requiredBy: []
  timestamp: '2022-10-04 23:14:38+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Kruskal_test.java
documentation_of: library/Kruskal.java
layout: document
redirect_from:
- /library/library/Kruskal.java
- /library/library/Kruskal.java.html
title: library/Kruskal.java
---
