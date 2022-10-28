---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/RollingHash.java
    title: library/RollingHash.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/zalgorithm
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
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
  timestamp: '2022-10-05 16:06:05+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/RollingHash_test.java
layout: document
redirect_from:
- /verify/library/RollingHash_test.java
- /verify/library/RollingHash_test.java.html
title: library/RollingHash_test.java
---
