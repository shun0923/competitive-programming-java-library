---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Dijkstra_reversed_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Dijkstra;\n\npublic class Dijkstra_reversed_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new Dijkstra_reversed_test());\
    \ }\n\n\tpublic void solve() {\n\t\twhile(true) {\n\t\t\tint n = ni();\n\t\t\t\
    int m = ni();\n\t\t\tint s = ni() - 1;\n\t\t\tint g1 = ni() - 1;\n\t\t\tint g2\
    \ = ni() - 1;\n\t\t\tif(n == 0) return;\n\t\t\tvar g = new ArrayWeightedGraph(n,\
    \ true);\n\t\t\tfor(int i = 0; i < m; i ++) g.add(ni() - 1, ni() - 1, nl());\n\
    \t\t\tlong distS[] = Dijkstra.dist(g, s);\n\t\t\tlong distG1[] = Dijkstra.dist(g.numNode,\
    \ g.reverseNodes(), g1);\n\t\t\tlong distG2[] = Dijkstra.dist(g.numNode, g.reverseNodes(),\
    \ g2);\n\t\t\tlong min = INF;\n\t\t\tfor(int i = 0; i < n; i ++) {\n\t\t\t\tif(isINF(distS[i])\
    \ || isINF(distG1[i]) || isINF(distG2[i])) continue;\n\t\t\t\tmin = min(min, distS[i]\
    \ + distG1[i] + distG2[i]);\n\t\t\t}\n\t\t\tprtln(min);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Dijkstra.java
  isVerificationFile: true
  path: library/Dijkstra_reversed_test.java
  requiredBy: []
  timestamp: '2022-10-02 20:26:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Dijkstra_reversed_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_reversed_test.java
- /verify/library/Dijkstra_reversed_test.java.html
title: library/Dijkstra_reversed_test.java
---
