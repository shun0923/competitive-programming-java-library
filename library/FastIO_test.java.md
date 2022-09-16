---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/aplusb
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/FastIO_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/aplusb\n\n\
    package library;\n\nimport library.Util;\n\npublic class FastIO_test extends Util\
    \ {\n\tpublic static void main(final String[] args) {\n\t\tDEBUG = args.length\
    \ > 0 && args[0].equals(\"-DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t,\
    \ e) -> { flush(); e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null,\
    \ new FastIO_test(), \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\
    \t\tprtln(nl() + nl());\n\t}\n}"
  dependsOn: []
  isVerificationFile: true
  path: library/FastIO_test.java
  requiredBy: []
  timestamp: '2022-09-17 00:44:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/FastIO_test.java
layout: document
redirect_from:
- /verify/library/FastIO_test.java
- /verify/library/FastIO_test.java.html
title: library/FastIO_test.java
---
