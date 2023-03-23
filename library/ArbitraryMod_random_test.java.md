---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
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
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.ArbitraryMod;\n\
    \npublic class ArbitraryMod_random_test extends Solver {\n\tpublic static void\
    \ main(final String[] args) { main(args, new ArbitraryMod_random_test()); }\n\n\
    \tpublic void solve() {\n\t\tRandom rnd = new Random();\n\t\tfor(int i = 0; i\
    \ < 10000000; i ++) checkAdd(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(Integer.MAX_VALUE\
    \ - 1) + 1);\n\t\tfor(int i = 0; i < 10000000; i ++) checkMul(rnd.nextInt(), rnd.nextInt(),\
    \ rnd.nextInt(Integer.MAX_VALUE - 1) + 1);\n\t\tfor(int i = 0; i < 10000000; i\
    \ ++) checkDiv(rnd.nextInt(), rnd.nextInt(), 998_244_353);\n\t\tfor(int i = 0;\
    \ i < 10000000; i ++) checkDiv(rnd.nextInt(), rnd.nextInt(), 1_000_000_007);\n\
    \t\tfor(int x = -100; x <= 100; x ++) {\n\t\t\tfor(int y = -100; y <= 100; y ++)\
    \ {\n\t\t\t\tfor(int m = 1; m <= 1000; m ++) {\n\t\t\t\t\tcheckAdd(x, y, m);\n\
    \t\t\t\t\tcheckMul(x, y, m);\n\t\t\t\t}\n\t\t\t\tcheckDiv(x, y, 998_244_353);\n\
    \t\t\t}\n\t\t}\n\t\tprtln(\"Hello World\");\n\t}\n\n\tpublic void checkAdd(long\
    \ x, long y, long m) {\n\t\tlong z = (x + y) % m; if(z < 0) z += m;\n\t\tassertion(z\
    \ == new ArbitraryMod(m).add(x, y));\n\t}\n\tpublic void checkMul(long x, long\
    \ y, long m) {\n\t\tlong z = (x * y) % m; if(z < 0) z += m;\n\t\tassertion(z ==\
    \ new ArbitraryMod(m).mul(x, y));\n\t}\n\tpublic void checkDiv(long x, long y,\
    \ long m) {\n\t\tif(y == 0) return;\n\t\tlong z = new ArbitraryMod(m).div(x, y);\n\
    \t\tassertion(z >= 0 && z < m && (z * y - x) % m == 0);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryMod_random_test.java
  requiredBy: []
  timestamp: '2022-10-31 15:43:25+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryMod_random_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryMod_random_test.java
- /verify/library/ArbitraryMod_random_test.java.html
title: library/ArbitraryMod_random_test.java
---