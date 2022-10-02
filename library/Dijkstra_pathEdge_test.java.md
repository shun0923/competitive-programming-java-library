---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':question:'
    path: library/RestorePath.java
    title: library/RestorePath.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/shortest_path
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Dijkstra_pathEdge_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.RestorePath;\nimport library.Dijkstra;\n\npublic class Dijkstra_pathEdge_test\
    \ extends Solver {\n\tpublic static void main(final String[] args) { main(args,\
    \ new Dijkstra_pathEdge_test()); }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\
    \t\tint m = ni();\n\t\tint s = ni();\n\t\tint t = ni();\n\t\tArrayWeightedGraph\
    \ g = new ArrayWeightedGraph(n, true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(),\
    \ ni(), nl());\n\t\tlong x = Dijkstra.dist(s)[t];\n\t\tif(isINF(x)) prtln(-1);\n\
    \t\telse {\n\t\t\tWeightedEdge path[] = Dijkstra.passEdge(s, t);\n\t\t\tprtln(x,\
    \ path.length);\n\t\t\tfor(WeightedEdge e : path) prtln(e.source, e.target);\n\
    \t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/RestorePath.java
  - library/Dijkstra.java
  isVerificationFile: true
  path: library/Dijkstra_pathEdge_test.java
  requiredBy: []
  timestamp: '2022-10-02 16:35:54+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Dijkstra_pathEdge_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_pathEdge_test.java
- /verify/library/Dijkstra_pathEdge_test.java.html
title: library/Dijkstra_pathEdge_test.java
---
