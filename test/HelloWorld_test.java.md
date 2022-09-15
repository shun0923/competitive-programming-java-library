---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/Main.java
    title: library/Main.java
  _extendedRequiredBy:
  - icon: ':x:'
    path: library/Main.java
    title: library/Main.java
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: test/HelloWorld_test.java\n"
  code: "// verification-helper: PROBLEM https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A\n\
    package test;\nimport library.Main;\n\npublic class HelloWorld_test extends Main\
    \ {\n\tpublic static void main(final String[] args) {\n\t\tThread.setDefaultUncaughtExceptionHandler((t,\
    \ e) -> { e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null, new HelloWorld_test(),\
    \ \"\", 1 << 31).start();\n\t}\n\n\t@Override\n\tpublic void solve() {\n\t\tSystem.out.println(\"\
    HelloWorld\");\n\t}\n}"
  dependsOn:
  - library/Main.java
  isVerificationFile: true
  path: test/HelloWorld_test.java
  requiredBy:
  - library/Main.java
  timestamp: '2022-09-15 13:30:12+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/HelloWorld_test.java
layout: document
redirect_from:
- /verify/test/HelloWorld_test.java
- /verify/test/HelloWorld_test.java.html
title: test/HelloWorld_test.java
---
