---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':question:'
    path: library/SuffixArray.java
    title: library/SuffixArray.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/suffixarray
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/suffixarray\n\
    \npackage library;\n\nimport library.Solver;\nimport library.SuffixArray;\n\n\
    public class SuffixArray_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new SuffixArray_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tprtln(SuffixArray.cal(ns()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/SuffixArray.java
  isVerificationFile: true
  path: library/SuffixArray_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/SuffixArray_test.java
layout: document
redirect_from:
- /verify/library/SuffixArray_test.java
- /verify/library/SuffixArray_test.java.html
title: library/SuffixArray_test.java
---
