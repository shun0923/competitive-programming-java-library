---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Kmp.java
    title: library/Kmp.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_B
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_B\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Kmp;\n\npublic class\
    \ Kmp_test extends Solver {\n\tpublic static void main(final String[] args) {\
    \ main(args, new Kmp_test()); }\n\n\tpublic void solve() {\n\t\tString t = ns();\n\
    \t\tprtlns(new Kmp(StringToInt(ns())).match(StringToInt(t)));\n\t}\n\n\tint[]\
    \ StringToInt(String s) {\n\t\tint a[] = new int[s.length()];\n\t\tfor(int i =\
    \ 0; i < s.length(); i ++) {\n\t\t\tint c = s.charAt(i);\n\t\t\tif('0' <= c &&\
    \ c <= '9') a[i] = c - '0';\n\t\t\telse if('a' <= c && c <= 'z') a[i] = c - 'a'\
    \ + 10;\n\t\t}\n\t\treturn a;\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Kmp.java
  isVerificationFile: true
  path: library/Kmp_test.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Kmp_test.java
layout: document
redirect_from:
- /verify/library/Kmp_test.java
- /verify/library/Kmp_test.java.html
title: library/Kmp_test.java
---
