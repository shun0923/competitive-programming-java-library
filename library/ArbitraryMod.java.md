---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_combination_test.java
    title: library/ArbitraryMod_combination_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_operation_test.java
    title: library/ArbitraryMod_operation_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_pow_test.java
    title: library/ArbitraryMod_pow_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_random_test.java
    title: library/ArbitraryMod_random_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_sqrt_test.java
    title: library/ArbitraryMod_sqrt_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
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
  code: "package library;\n\nimport library.Mod;\n\nfinal class ArbitraryMod extends\
    \ Mod {\n\tprivate static final long MASK = 0xffff_ffffl;\n\tprivate final long\
    \ MH;\n\tprivate final long ML;\n\tpublic ArbitraryMod(long mod) {\n\t\tsuper(mod);\n\
    \t\tfinal long a = (1l << 32) / MOD;\n\t\tfinal long b = (1l << 32) % MOD;\n\t\
    \tfinal long m = a * a * MOD + 2 * a * b + (b * b) / MOD;\n\t\tMH = m >>> 32;\n\
    \t\tML = m & MASK;\n\t}\n\n\tprivate final long reduce(long x) {\n\t\tif(MOD ==\
    \ 1) return 0;\n\t\tif(x < 0) return (x = reduce(- x)) == 0 ? 0 : MOD - x;\n\t\
    \tlong z = (x & MASK) * ML;\n\t\tz = (x & MASK) * MH + (x >>> 32) * ML + (z >>>\
    \ 32);\n\t\tz = (x >>> 32) * MH + (z >>> 32);\n\t\tx -= z * MOD;\n\t\treturn x\
    \ < MOD ? x : x - MOD;\n\t}\n\t@Override\n\tpublic long mod(long x) {\n\t\tif(0\
    \ <= x && x < MOD) return x;\n\t\tif(- MOD <= x && x < 0) return x + MOD;\n\t\t\
    return reduce(x);\n\t}\n\t@Override\n\tpublic long mul(long x, long y) {\n\t\t\
    if(x >= 0 && x < MOD && y >= 0 && y < MOD) return reduce(x * y);\n\t\tx = mod(x);\n\
    \t\ty = mod(y);\n\t\treturn reduce(x * y);\n\t}\n}"
  dependsOn:
  - library/Mod.java
  isVerificationFile: false
  path: library/ArbitraryMod.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/ArbitraryMod_sqrt_test.java
  - library/ArbitraryMod_combination_test.java
  - library/ArbitraryMod_operation_test.java
  - library/ArbitraryMod_pow_test.java
  - library/ArbitraryMod_random_test.java
documentation_of: library/ArbitraryMod.java
layout: document
redirect_from:
- /library/library/ArbitraryMod.java
- /library/library/ArbitraryMod.java.html
title: library/ArbitraryMod.java
---
