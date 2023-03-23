---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Permutation.java
    title: library/Permutation.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP2_5_D
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP2_5_D\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Permutation;\n\n\
    public class Permutation_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Permutation_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint a0[] = new int[n];\n\t\tfor(int i = 0; i < n;\
    \ i ++) a0[i] = i + 1;\n\t\tfor(int[] a : new Permutation(a0)) prtln(a);\n\t}\n\
    }"
  dependsOn:
  - library/Solver.java
  - library/Permutation.java
  isVerificationFile: true
  path: library/Permutation_test.java
  requiredBy: []
  timestamp: '2022-10-04 10:50:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Permutation_test.java
layout: document
redirect_from:
- /verify/library/Permutation_test.java
- /verify/library/Permutation_test.java.html
title: library/Permutation_test.java
---
