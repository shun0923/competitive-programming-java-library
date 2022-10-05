---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/LcpArray.java
    title: library/LcpArray.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/SuffixArray.java
    title: library/SuffixArray.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/number_of_substrings
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/number_of_substrings\n\
    \npackage library;\n\nimport library.Solver;\nimport library.SuffixArray;\nimport\
    \ library.LcpArray;\n\npublic class LcpArray_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new LcpArray_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tString s = ns();\n\t\tprtln((long)s.length() * (s.length()\
    \ + 1) / 2 - sum(LcpArray.cal(s)));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/SuffixArray.java
  - library/LcpArray.java
  isVerificationFile: true
  path: library/LcpArray_test.java
  requiredBy: []
  timestamp: '2022-10-05 16:19:10+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/LcpArray_test.java
layout: document
redirect_from:
- /verify/library/LcpArray_test.java
- /verify/library/LcpArray_test.java.html
title: library/LcpArray_test.java
---
