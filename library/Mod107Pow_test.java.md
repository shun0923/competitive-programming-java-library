---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Mod107Pow_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Util;\nimport library.Mod;\n\
    \npublic class Mod107Pow_test extends Util {\n\tpublic static void main(final\
    \ String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\
    \t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace();\
    \ System.exit(1); });\n\t\tnew Thread(null, new Mod107Pow_test(), \"\", 1 << 31).start();\n\
    \t}\n\n\tpublic void solve() {\n\t\tprtln(Mod107.md.pow(nl(), nl()));\n\t}\n}"
  dependsOn:
  - library/Util.java
  - library/Mod.java
  isVerificationFile: true
  path: library/Mod107Pow_test.java
  requiredBy: []
  timestamp: '2022-09-17 17:52:24+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Mod107Pow_test.java
layout: document
redirect_from:
- /verify/library/Mod107Pow_test.java
- /verify/library/Mod107Pow_test.java.html
title: library/Mod107Pow_test.java
---
