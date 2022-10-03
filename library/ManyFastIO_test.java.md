---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/many_aplusb
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/many_aplusb\n\
    \npackage library;\n\nimport library.Solver;\nimport library.FastInputStream;\n\
    import library.FastOutputStream;\n\npublic class ManyFastIO_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new ManyFastIO_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint t = ni();\n\t\tfor(int i = 0; i < t; i\
    \ ++) prtln(nl() + nl());\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  isVerificationFile: true
  path: library/ManyFastIO_test.java
  requiredBy: []
  timestamp: '2022-10-03 15:04:10+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ManyFastIO_test.java
layout: document
redirect_from:
- /verify/library/ManyFastIO_test.java
- /verify/library/ManyFastIO_test.java.html
title: library/ManyFastIO_test.java
---
