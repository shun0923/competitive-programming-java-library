---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  - icon: ':x:'
    path: test/ManyFastIO_test.java
    title: test/ManyFastIO_test.java
  _extendedRequiredBy:
  - icon: ':question:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  - icon: ':x:'
    path: test/ManyFastIO_test.java
    title: test/ManyFastIO_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/aplusb
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: test/FastIO_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/aplusb\n\
    package test;\n\nimport library.Solver;\n\npublic class HelloWorld_test extends\
    \ Solver {\n\tpublic static void main(final String[] args) {\n\t\tDEBUG = args.length\
    \ > 0 && args[0].equals(\"-DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t,\
    \ e) -> { flush(); e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null,\
    \ new HelloWorld_test(), \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve()\
    \ {\n\t\tprtln(nl() + nl());\n\t}\n}"
  dependsOn:
  - test/HelloWorld_test.java
  - test/ManyFastIO_test.java
  - library/FastInputStream.java
  - library/Solver.java
  - library/FastOutputStream.java
  isVerificationFile: true
  path: test/FastIO_test.java
  requiredBy:
  - library/FastInputStream.java
  - library/Solver.java
  - library/FastOutputStream.java
  timestamp: '2022-09-16 17:40:01+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith:
  - test/HelloWorld_test.java
  - test/ManyFastIO_test.java
documentation_of: test/FastIO_test.java
layout: document
redirect_from:
- /verify/test/FastIO_test.java
- /verify/test/FastIO_test.java.html
title: test/FastIO_test.java
---
