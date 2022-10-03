---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra.java
    title: library/TemplateDijkstra.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplateDijkstra_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.TemplateDijkstra;\n\npublic class TemplateDijkstra_test extends\
    \ Solver {\n\tpublic static void main(final String[] args) { main(args, new TemplateDijkstra_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tint\
    \ r = ni();\n\t\tArrayTemplateGraph<Long> g = new ArrayTemplateGraph<>(n, true);\n\
    \t\tfor(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());\n\t\tTemplateDijkstra<Long>\
    \ djk = new TemplateDijkstra<>(() -> 0l, (dist, cost) -> dist + cost,\n\t\t\t\
    Comparator.comparing((ele) -> ele));\n\t\tfor(Long ele : djk.dist(g, r)) prtln(ele\
    \ == null ? \"INF\" : ele);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/TemplateDijkstra.java
  isVerificationFile: true
  path: library/TemplateDijkstra_test.java
  requiredBy: []
  timestamp: '2022-10-03 14:30:02+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplateDijkstra_test.java
layout: document
redirect_from:
- /verify/library/TemplateDijkstra_test.java
- /verify/library/TemplateDijkstra_test.java.html
title: library/TemplateDijkstra_test.java
---
