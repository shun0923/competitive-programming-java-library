---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/convolution_mod_1000000007
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Convolution107_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/convolution_mod_1000000007\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Util;\nimport library.Convolution107;\n\
    \npublic class Convolution107_test extends Util {\n\tpublic static void main(final\
    \ String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\
    \t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace();\
    \ System.exit(1); });\n\t\tnew Thread(null, new Convolution107_test(), \"\", 1\
    \ << 31).start();\n\t}\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint\
    \ m = ni();\n\t\tprtln(Convolution107.cnv.cnv(nl(n), nl(m)));\n\t}\n}"
  dependsOn:
  - library/Util.java
  isVerificationFile: true
  path: library/Convolution107_test.java
  requiredBy: []
  timestamp: '2022-09-18 23:53:33+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Convolution107_test.java
layout: document
redirect_from:
- /verify/library/Convolution107_test.java
- /verify/library/Convolution107_test.java.html
title: library/Convolution107_test.java
---
