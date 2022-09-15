---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Main.java\n"
  code: "package library;\n\npublic class Main implements Runnable {\n\tpublic static\
    \ void main(final String[] args) {\n\t\tThread.setDefaultUncaughtExceptionHandler((t,\
    \ e) -> { e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null, new Main(),\
    \ \"\", 1 << 31).start();\n\t}\n\n\t@Override\n\tpublic void run() { solve();\
    \ }\n\n\tpublic void solve() {\n\n\t}\n}"
  dependsOn:
  - test/HelloWorld_test.java
  isVerificationFile: false
  path: library/Main.java
  requiredBy: []
  timestamp: '2022-09-15 13:30:12+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/HelloWorld_test.java
documentation_of: library/Main.java
layout: document
redirect_from:
- /library/library/Main.java
- /library/library/Main.java.html
title: library/Main.java
---
