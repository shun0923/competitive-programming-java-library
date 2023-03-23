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
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/shortest_path
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.PathRestoration;\nimport library.Dijkstra;\n\npublic class Dijkstra_pathEdge_test\
    \ extends Solver {\n\tpublic static void main(final String[] args) { main(args,\
    \ new Dijkstra_pathEdge_test()); }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\
    \t\tint m = ni();\n\t\tint s = ni();\n\t\tint t = ni();\n\t\tvar g = new WeightedListGraph(n,\
    \ true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());\n\t\tint prv[]\
    \ = new int[n];\n\t\tWeightedEdge prvEdge[] = new WeightedEdge[n];\n\t\tlong x\
    \ = Dijkstra.dist(g, s, prv, prvEdge)[t];\n\t\tif(isINF(x)) prtln(-1);\n\t\telse\
    \ {\n\t\t\tvar path = PathRestoration.pathEdge(prv, prvEdge, s, t);\n\t\t\tprtln(x,\
    \ path.size());\n\t\t\tfor(WeightedEdge e : path) prtln(e.source, e.target);\n\
    \t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/PathRestoration.java
  - library/Dijkstra.java
  isVerificationFile: true
  path: library/Dijkstra_pathEdge_test.java
  requiredBy: []
  timestamp: '2023-03-24 01:50:05+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Dijkstra_pathEdge_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_pathEdge_test.java
- /verify/library/Dijkstra_pathEdge_test.java.html
title: library/Dijkstra_pathEdge_test.java
---
