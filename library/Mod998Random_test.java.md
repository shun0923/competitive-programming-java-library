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
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Mod998Random_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.Mod;\n\
    \npublic class Mod998Random_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Mod998Random_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tRandom rnd = new Random(0);\n\t\tfor(int i = 0; i < 10000000; i ++) checkAdd(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int i = 0; i < 10000000; i ++) checkMul(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int x = -3000; x <= 3000; x ++) {\n\t\t\tfor(int y\
    \ = -3000; y <= 3000; y ++) {\n\t\t\t\tcheckDiv(x, y);\n\t\t\t}\n\t\t}\n\t\tprtln(\"\
    Hello World\");\n\t}\n\n\tpublic void checkAdd(long x, long y) {\n\t\tlong z =\
    \ (x + y) % 998_244_353; if(z < 0) z += 998_244_353;\n\t\tassertion(z == Mod998.md.add(x,\
    \ y));\n\t}\n\tpublic void checkMul(long x, long y) {\n\t\tlong z = (x * y) %\
    \ 998_244_353; if(z < 0) z += 998_244_353;\n\t\tassertion(z == Mod998.md.mul(x,\
    \ y));\n\t}\n\tpublic void checkDiv(long x, long y) {\n\t\tif(y == 0) return;\n\
    \t\tlong z = Mod998.md.div(x, y);\n\t\tassertion(z >= 0 && z < 998_244_353 &&\
    \ (z * y - x) % 998_244_353 == 0);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  isVerificationFile: true
  path: library/Mod998Random_test.java
  requiredBy: []
  timestamp: '2022-09-20 15:28:33+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Mod998Random_test.java
layout: document
redirect_from:
- /verify/library/Mod998Random_test.java
- /verify/library/Mod998Random_test.java.html
title: library/Mod998Random_test.java
---