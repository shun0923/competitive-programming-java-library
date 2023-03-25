---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/MaxFlow.java
    title: library/MaxFlow.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_6_A
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_6_A\n\
    \npackage library;\n\nimport library.Solver;\nimport library.MaxFlow;\n\npublic\
    \ class MaxFlow_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new MaxFlow_test()); }\n\n\tpublic void solve() {\n\t\tint\
    \ n = ni();\n\t\tint m = ni();\n\t\tMaxFlow mf = new MaxFlow(n);\n\t\tfor(int\
    \ i = 0; i < m; i ++) mf.add(ni(), ni(), nl());\n\t\tprtln(mf.maxFlow(0, n - 1));\n\
    \t}\n}"
  dependsOn:
  - library/Solver.java
  - library/MaxFlow.java
  isVerificationFile: true
  path: library/MaxFlow_test.java
  requiredBy: []
  timestamp: '2023-03-25 16:20:34+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/MaxFlow_test.java
layout: document
redirect_from:
- /verify/library/MaxFlow_test.java
- /verify/library/MaxFlow_test.java.html
title: library/MaxFlow_test.java
---
