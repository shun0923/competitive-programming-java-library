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
    path: library/PathRestoration.java
    title: library/PathRestoration.java
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
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.PathRestoration;\nimport library.Dijkstra;\n\npublic class Dijkstra_pathEdge_test\
    \ extends Solver {\n\tpublic static void main(final String[] args) { main(args,\
    \ new Dijkstra_pathEdge_test()); }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\
    \t\tint m = ni();\n\t\tint s = ni();\n\t\tint t = ni();\n\t\tArrayWeightedGraph\
    \ g = new ArrayWeightedGraph(n, true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(),\
    \ ni(), nl());\n\t\tlong x = Dijkstra.dist(g, s, true)[t];\n\t\tif(isINF(x)) prtln(-1);\n\
    \t\telse {\n\t\t\tArrayWeightedNode path = Dijkstra.pathEdge(s, t);\n\t\t\tprtln(x,\
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
  timestamp: '2022-10-02 20:26:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Dijkstra_pathEdge_test.java
layout: document
redirect_from:
- /verify/library/Dijkstra_pathEdge_test.java
- /verify/library/Dijkstra_pathEdge_test.java.html
title: library/Dijkstra_pathEdge_test.java
---
