---
data:
  _extendedDependsOn:
  - icon: ':question:'
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
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_12_C
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_12_C\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Dijkstra;\n\npublic class Dijkstra_forDenseGraph_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new Dijkstra_forDenseGraph_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tArrayWeightedGraph g =\
    \ new ArrayWeightedGraph(n, true);\n\t\tfor(int i = 0; i < n; i ++) {\n\t\t\t\
    int u = ni();\n\t\t\tint k = ni();\n\t\t\tfor(int j = 0; j < k; j ++) g.add(u,\
    \ ni(), nl());\n\t\t}\n\t\tlong dist[] = Dijkstra.distForDenseGraph(g, 0);\n\t\
    \tfor(int i = 0; i < n; i ++) prtln(i, dist[i]);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Dijkstra.java
  isVerificationFile: true
  path: library/Dijkstra_forDenseGraph_test.java
  requiredBy: []
  timestamp: '2022-10-04 23:14:38+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Dijkstra_forDenseGraph_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_forDenseGraph_test.java
- /verify/library/Dijkstra_forDenseGraph_test.java.html
title: library/Dijkstra_forDenseGraph_test.java
---
