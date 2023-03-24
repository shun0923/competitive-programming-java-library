---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
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
    import library.UnionFind;\n\nclass Kruskal {\n\tprivate static UnionFind uf;\n\
    \t// O(ElogV)\n\tpublic static final long cal(AbstractGraph<? extends WeightedNode,\
    \ WeightedEdge> g) { return cal(g, null); }\n\tpublic static final long cal(AbstractGraph<?\
    \ extends WeightedNode, WeightedEdge> g, WeightedNode used) { return cal(g.numNode,\
    \ g.edges(), used); }\n\tpublic static final long cal(int numNode, WeightedNode\
    \ edges) { return cal(numNode, edges, null); }\n\tpublic static final long cal(int\
    \ numNode, WeightedNode edges, WeightedNode used) {\n\t\tuf = new UnionFind(numNode);\n\
    \t\tif(used != null) used.clear();\n\t\tQueue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();\n\
    \t\tfor(WeightedEdge e : edges) if(!FastIO.isINF(e.cost)) pq.add(e);\n\n\t\tlong\
    \ cost = 0;\n\t\twhile(!pq.isEmpty()) {\n\t\t\tWeightedEdge e = pq.poll();\n\t\
    \t\tif(!uf.same(e.source, e.target)) {\n\t\t\t\tcost += e.cost;\n\t\t\t\tuf.unite(e);\n\
    \t\t\t\tif(used != null) used.add(e);\n\t\t\t}\n\t\t}\n\t\treturn cost;\n\t}\n\
    }"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  - library/UnionFind.java
  isVerificationFile: false
  path: library/Kruskal.java
  requiredBy: []
  timestamp: '2023-03-25 01:16:43+09:00'
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
