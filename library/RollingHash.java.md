---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/RollingHash_test.java
    title: library/RollingHash_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.SimpleUtil;\n\nfinal class RollingHash\
    \ {\n\tstatic final long MASK30 = (1l << 30) - 1;\n\tstatic final long MASK31\
    \ = (1l << 31) - 1;\n\tstatic final long MODRH = (1l << 61) - 1;\n\tstatic final\
    \ long MASK61 = MODRH;\n\tstatic final long POSITIVIZER = MODRH * 4;\n\tstatic\
    \ final long BASE = (int)(Math.random() * (MODRH - MODRH >>> 1)) + (MODRH >>>\
    \ 1);\n\tprivate final long hash[];\n\tprivate final long pow[];\n\tpublic final\
    \ int len;\n\n\tprivate static final long mul(final long a, final long b) { //\
    \ O(1)\n\t\tlong au = a >>> 31;\n\t\tlong ad = a & MASK31;\n\t\tlong bu = b >>>\
    \ 31;\n\t\tlong bd = b & MASK31;\n\t\tlong mid = ad * bu + au * bd;\n\t\tlong\
    \ midu = mid >>> 30;\n\t\tlong midd = mid & MASK30;\n\t\treturn au * bu * 2 +\
    \ midu + (midd << 31) + ad * bd;\n\t}\n\tprivate static final long mod(final long\
    \ x) { // O(1)\n\t\tlong xu = x >> 61;\n\t\tlong xd = x & MASK61;\n\t\tlong res\
    \ = xu + xd;\n\t\tif(res >= MODRH) res -= MODRH;\n\t\treturn res;\n\t}\n\n\tprivate\
    \ static final int[] charToInt(char[] c) {\n\t\tint a[] = new int[c.length];\n\
    \t\tfor(int i = 0; i < c.length; i ++) a[i] = (int)c[i];\n\t\treturn a;\n\t}\n\
    \n\t// O(|S|)\n\tpublic RollingHash(String s) { this(s.toCharArray()); }\n\tpublic\
    \ RollingHash(char[] c) { this(charToInt(c)); }\n\tpublic RollingHash(int[] a)\
    \ {\n\t\tlen = a.length;\n\t\thash = new long[len + 1];\n\t\tpow = new long[len\
    \ + 1];\n\t\thash[0] = 0;\n\t\tpow[0] = 1;\n\t\tfor(int i = 0; i < len; i ++)\
    \ {\n\t\t\thash[i + 1] = mod(mul(hash[i], BASE) + a[i]);\n\t\t\tpow[i + 1] = mod(mul(pow[i],\
    \ BASE));\n\t\t}\n\t}\n\n\t// return the hash of S[l,r) // O(1)\n\tpublic final\
    \ long get(int l, int r) {\n\t\tSimpleUtil.inclusiveRangeCheck(l, len);\n\t\t\
    SimpleUtil.inclusiveRangeCheck(r, len);\n\t\tSimpleUtil.assertion(l <= r, \"l\
    \ is larger than r.\");\n\t\tlong res = hash[r] - mul(hash[l], pow[r - l]);\n\t\
    \tif(res < 0) res += POSITIVIZER;\n\t\treturn mod(res);\n\t}\n\tpublic final long\
    \ get() { return hash[len]; }\n\n\tpublic static final int lcp(RollingHash rh1,\
    \ int a, RollingHash rh2, int b) { // O(max(|S_1|,|S_2|))\n\t\tSimpleUtil.inclusiveRangeCheck(a,\
    \ rh1.len);\n\t\tSimpleUtil.inclusiveRangeCheck(b, rh2.len);\n\t\tint ok = 0;\n\
    \t\tint ng = Math.min(rh1.len - a, rh2.len - b) + 1;\n\t\twhile(ng - ok != 1)\
    \ {\n\t\t\tint mid = ok + (ng - ok >> 1);\n\t\t\tif(rh1.get(a, a + mid) == (rh2.get(b,\
    \ b + mid))) ok = mid; else ng = mid;\n\t\t}\n\t\treturn ok;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/RollingHash.java
  requiredBy: []
  timestamp: '2022-10-05 14:57:37+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/RollingHash_test.java
documentation_of: library/RollingHash.java
layout: document
redirect_from:
- /library/library/RollingHash.java
- /library/library/RollingHash.java.html
title: library/RollingHash.java
---
