---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/WarshallFloyd.java
    title: library/WarshallFloyd.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_C
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/WarshallFloyd_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_C\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.WarshallFloyd;\n\npublic class WarshallFloyd_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new WarshallFloyd_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tArrayWeightedGraph\
    \ g = new ArrayWeightedGraph(n, true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(),\
    \ ni(), nl());\n\t\tlong dist[][] = WarshallFloyd.dist(g);\n\t\tfor(int i = 0;\
    \ i < n; i ++) if(dist[i][i] < 0) { prtln(\"NEGATIVE CYCLE\"); return; }\n\t\t\
    String ans[][] = new String[n][n];\n\t\tfor(int i = 0; i < n; i ++) for(int j\
    \ = 0; j < n; j ++) {\n\t\t\tans[i][j] = isINF(dist[i][j]) ? \"INF\" : String.valueOf(dist[i][j]);\n\
    \t\t}\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/WarshallFloyd.java
  isVerificationFile: true
  path: library/WarshallFloyd_test.java
  requiredBy: []
  timestamp: '2022-10-02 19:48:55+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/WarshallFloyd_test.java
layout: document
redirect_from:
- /verify/library/WarshallFloyd_test.java
- /verify/library/WarshallFloyd_test.java.html
title: library/WarshallFloyd_test.java
---
