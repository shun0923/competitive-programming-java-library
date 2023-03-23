---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TopologicalSort.java
    title: library/TopologicalSort.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/468
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
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/468\n\n\
    package library;\n\nimport library.Solver;\nimport library.AbstractGraph;\nimport\
    \ library.TopologicalSort;\n\npublic class TopologicalSort_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new TopologicalSort_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tvar\
    \ g = new WeightedListGraph(n, true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(),\
    \ ni(), nl());\n\t\tlong dist1[] = cal(n, g.nodes(), g.edges());\n\t\tlong dist2[]\
    \ = cal(n, g.reverseNodes(), g.reverseEdges());\n\t\tfor(int i = 0; i < n; i ++)\
    \ dist2[i] = dist1[0] - dist2[i];\n\t\tint cnt = 0;\n\t\tfor(int i = 0; i < n;\
    \ i ++) if(dist1[i] != dist2[i]) cnt ++;\n\t\tprtln(dist1[0]+\" \"+cnt+\"/\"+n);\n\
    \t}\n\n\tlong[] cal(int n, WeightedNode[] nodes, WeightedNode edges) {\n\t\tint\
    \ sorted[] = TopologicalSort.sort(nodes, edges);\n\t\treverse(sorted);\n\t\tlong\
    \ dist[] = new long[n];\n\t\tdist[sorted[0]] = 0;\n\t\tfor(int i : sorted) {\n\
    \t\t\tfor(WeightedEdge e : nodes[i]) {\n\t\t\t\tdist[i] = max(dist[i], dist[e.target]\
    \ + e.cost);\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/TopologicalSort.java
  isVerificationFile: true
  path: library/TopologicalSort_test.java
  requiredBy: []
  timestamp: '2023-03-24 01:50:11+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TopologicalSort_test.java
layout: document
redirect_from:
- /verify/library/TopologicalSort_test.java
- /verify/library/TopologicalSort_test.java.html
title: library/TopologicalSort_test.java
---
