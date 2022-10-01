---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/shortest_path
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Dijkstra_pass_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Dijkstra;\n\npublic class Dijkstra_pass_test extends Solver {\n\
    \tpublic static void main(final String[] args) { main(args, new Dijkstra_pass_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tint\
    \ s = ni();\n\t\tint t = ni();\n\t\tArrayWeightedGraph g = new ArrayWeightedGraph(n,\
    \ true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());\n\t\tlong x\
    \ = Dijkstra.dist(g, s)[t];\n\t\tif(isINF(x)) prtln(-1);\n\t\telse {\n\t\t\tint\
    \ pass[] = Dijkstra.pass(s, t);\n\t\t\tprtln(x, pass.length - 1);\n\t\t\tfor(int\
    \ i = 0; i < pass.length - 1; i ++) prtln(pass[i], pass[i + 1]);\n\t\t}\n\t}\n\
    }"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Dijkstra.java
  isVerificationFile: true
  path: library/Dijkstra_pass_test.java
  requiredBy: []
  timestamp: '2022-10-01 16:55:20+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Dijkstra_pass_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_pass_test.java
- /verify/library/Dijkstra_pass_test.java.html
title: library/Dijkstra_pass_test.java
---
