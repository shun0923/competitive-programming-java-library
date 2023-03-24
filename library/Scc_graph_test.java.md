---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Scc.java
    title: library/Scc.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0366
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0366\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Scc;\n\npublic class Scc_graph_test extends Solver {\n\tpublic\
    \ static void main(final String[] args) { main(args, new Scc_graph_test()); }\n\
    \n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tvar g = new\
    \ UnweightedListGraph(n, true);\n\t\tfor(int i = 0; i < m; i ++) g.add(ni(), ni());\n\
    \t\tvar contracted = Scc.calGraph(g);\n\t\tint leaf = 0;\n\t\tfor(UnweightedNode\
    \ node : contracted.nodes()) if(node.size() == 0) leaf ++;\n\t\tint root = 0;\n\
    \t\tfor(UnweightedNode node : contracted.reverseNodes()) if(node.size() == 0)\
    \ root ++;\n\t\tprtln(contracted.numNode == 1 ? 0 : max(root, leaf));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Scc.java
  isVerificationFile: true
  path: library/Scc_graph_test.java
  requiredBy: []
  timestamp: '2023-03-25 01:16:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Scc_graph_test.java
layout: document
redirect_from:
- /verify/library/Scc_graph_test.java
- /verify/library/Scc_graph_test.java.html
title: library/Scc_graph_test.java
---
