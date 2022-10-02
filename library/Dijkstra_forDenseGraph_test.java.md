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
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0189
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Dijkstra_forDenseGraph_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0189\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Dijkstra;\n\npublic class Dijkstra_forDenseGraph_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new Dijkstra_forDenseGraph_test());\
    \ }\n\n\tpublic void solve() {\n\t\twhile(true) {\n\t\t\tint n = ni();\n\t\t\t\
    if(n == 0) return;\n\t\t\tArrayWeightedNode edges = new ArrayWeightedNode(-1);\n\
    \t\t\tfor(int i = 0; i < n; i ++) edges.add(new WeightedEdge(ni(), ni(), nl()));\n\
    \t\t\tint m = 0;\n\t\t\tfor(WeightedEdge e : edges) m = max(m, e.source, e.target);\n\
    \t\t\tm ++;\n\t\t\tArrayWeightedGraph g = new ArrayWeightedGraph(m, false);\n\t\
    \t\tg.addAll(edges);\n\t\t\tlong dist[][] = new long[m][];\n\t\t\tfor(int i =\
    \ 0; i < m; i ++) dist[i] = Dijkstra.distForDenseGraph(g, i);\n\t\t\tlong sum[]\
    \ = new long[m];\n\t\t\tfor(int i = 0; i < m; i ++) sum[i] = sum(dist[i]);\n\t\
    \t\tint idx = 0;\n\t\t\tfor(int i = 0; i < m; i ++) if(sum[i] < sum[idx]) idx\
    \ = i;\n\t\t\tprtln(idx, sum[idx]);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Dijkstra.java
  isVerificationFile: true
  path: library/Dijkstra_forDenseGraph_test.java
  requiredBy: []
  timestamp: '2022-10-02 20:26:48+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Dijkstra_forDenseGraph_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_forDenseGraph_test.java
- /verify/library/Dijkstra_forDenseGraph_test.java.html
title: library/Dijkstra_forDenseGraph_test.java
---
