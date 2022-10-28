---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/ZAlgorithm.java
    title: library/ZAlgorithm.java
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
    \npackage library;\n\nimport library.Solver;\nimport library.ZAlgorithm;\n\npublic\
    \ class ZAlgorithm_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new ZAlgorithm_test()); }\n\n\tpublic void solve() {\n\t\t\
    prtln(ZAlgorithm.cal(ns()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/ZAlgorithm.java
  isVerificationFile: true
  path: library/ZAlgorithm_test.java
  requiredBy: []
  timestamp: '2022-10-05 16:52:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ZAlgorithm_test.java
layout: document
redirect_from:
- /verify/library/ZAlgorithm_test.java
- /verify/library/ZAlgorithm_test.java.html
title: library/ZAlgorithm_test.java
---