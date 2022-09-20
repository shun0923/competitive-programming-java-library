---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1186
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Mod998ManyCombination_test.java\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1186\n\n\
    package library;\n\nimport library.Solver;\nimport library.Mod;\n\npublic class\
    \ Mod998ManyCombination_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Mod998ManyCombination_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tMod md = Mod998.md;\n\t\tint n = ni();\n\t\tint m = ni();\n\
    \t\tif(n == 1) prtln(1);\n\t\telse {\n\t\t\tlong ans = 0;\n\t\t\tfor(int x = 0;\
    \ x <= m / n; x ++) {\n\t\t\t\tans = md.add(ans, md.H(x + 1, m - x * n));\n\t\t\
    \t}\n\t\t\tprtln(ans);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  isVerificationFile: true
  path: library/Mod998ManyCombination_test.java
  requiredBy: []
  timestamp: '2022-09-20 15:28:33+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Mod998ManyCombination_test.java
layout: document
redirect_from:
- /verify/library/Mod998ManyCombination_test.java
- /verify/library/Mod998ManyCombination_test.java.html
title: library/Mod998ManyCombination_test.java
---
