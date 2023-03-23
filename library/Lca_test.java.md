---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':x:'
    path: library/Lca.java
    title: library/Lca.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/lca
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/lca\n\npackage\
    \ library;\n\nimport library.Solver;\nimport library.AbstractGraph;\nimport library.Lca;\n\
    \npublic class Lca_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new Lca_test()); }\n\n\tpublic void solve() {\n\t\tint n\
    \ = ni();\n\t\tint q = ni();\n\t\tArrayUnweightedGraph g = new ArrayUnweightedGraph(n,\
    \ false);\n\t\tfor(int i = 1; i < n; i ++) g.add(ni(), i);\n\t\tLca lca = new\
    \ Lca(g, 0);\n\t\tfor(int i = 0; i < q; i ++) prtln(lca.cal(ni(), ni()));\n\t\
    }\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Lca.java
  isVerificationFile: true
  path: library/Lca_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Lca_test.java
layout: document
redirect_from:
- /verify/library/Lca_test.java
- /verify/library/Lca_test.java.html
title: library/Lca_test.java
---