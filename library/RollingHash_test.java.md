---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/RollingHash.java
    title: library/RollingHash.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/zalgorithm
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/zalgorithm\n\
    \npackage library;\n\nimport library.Solver;\nimport library.RollingHash;\n\n\
    public class RollingHash_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new RollingHash_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tRollingHash rh = new RollingHash(ns());\n\t\tint lcp[] = new int[rh.len];\n\
    \t\tfor(int i = 0; i < rh.len; i ++) lcp[i] = RollingHash.lcp(rh, 0, rh, i);\n\
    \t\tprtln(lcp);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/RollingHash.java
  isVerificationFile: true
  path: library/RollingHash_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/RollingHash_test.java
layout: document
redirect_from:
- /verify/library/RollingHash_test.java
- /verify/library/RollingHash_test.java.html
title: library/RollingHash_test.java
---
