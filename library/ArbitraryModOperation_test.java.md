---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1092
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryModOperation_test.java\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1092\n\n\
    package library;\n\nimport java.util.*;\nimport library.Util;\nimport library.ArbitraryMod;\n\
    \npublic class ArbitraryModOperation_test extends Util {\n\tpublic static void\
    \ main(final String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"\
    -DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush();\
    \ e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null, new ArbitraryModOperation_test(),\
    \ \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\t\tMod md = new ArbitraryMod(nl());\n\
    \t\tint n = ni() - 1;\n\t\tlong ans = nl();\n\t\tlong a[] = nl(n);\n\t\tfor(long\
    \ ele : a) {\n\t\t\tswitch(nc()) {\n\t\t\tcase '+': ans = md.add(ans, ele); break;\n\
    \t\t\tcase '-': ans = md.sub(ans, ele); break;\n\t\t\tcase '*': ans = md.mul(ans,\
    \ ele); break;\n\t\t\tcase '/': ans = md.div(ans, ele); break;\n\t\t\t}\n\t\t\
    }\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Util.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryModOperation_test.java
  requiredBy: []
  timestamp: '2022-09-17 23:18:18+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryModOperation_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryModOperation_test.java
- /verify/library/ArbitraryModOperation_test.java.html
title: library/ArbitraryModOperation_test.java
---
