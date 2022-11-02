---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':heavy_check_mark:'
    path: library/Fps.java
    title: library/Fps.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.Mod;\nimport library.Convolution;\nimport\
    \ library.Fps;\n\nclass Kitamasa {\n\t\t// O(LlogLlogN)\n\t// return a_n\n\t//\
    \ a_k = sum c_i a_(k-i-1)\n\tpublic static final long cal(FpsOperator op, long[]\
    \ a, long[] c, long n) {\n\t\tif(n < a.length) return a[(int)n];\n\t\tFps q =\
    \ op.lshift(new Fps(op, c), 1).negate().set(0, 1);\n\t\tif(a.length < q.size()\
    \ - 1) return -1;\n\t\tFps p = new Fps(op, a, q.size() - 1).mul(q);\n\t\treturn\
    \ linearRecurrence(op, p, q, n);\n\t}\n\t\n\t// return [x^n] p/q\n\tpublic static\
    \ final long linearRecurrence(final FpsOperator op, Fps p, Fps q, final long n)\
    \ {\n\t\tq = op.shrink(q);\n\t\tlong ans = 0;\n\t\tif(p.size() >= q.size()) {\n\
    \t\t\tFps r = op.divfloor(p, q);\n\t\t\tif(n < r.size()) ans = r.a[(int)n];\n\t\
    \t\tp.sub(r.mul(q));\n\t\t\tp = op.shrink(p);\n\t\t}\n\t\tif(p.size() == 0) return\
    \ ans;\n\t\treturn op.md.add(ans, calLinearRecurrence(op, p, q, n));\n\t}\n\t\
    public static final long calLinearRecurrence(final CnvFpsOperator op, Fps p, Fps\
    \ q, long n) {\n\t\tMod md = op.md;\n\t\tint size = 1;\n\t\tint log = 0;\n\t\t\
    while(size < q.size()) { size <<= 1; log ++; }\n\t\tFps f = op.butterfly(p, size\
    \ << 1);\n\t\tFps g = op.butterfly(q, size << 1);\n\n\t\tint btr[] = new int[size];\n\
    \t\tfor(int i = 0; i < size; i ++) btr[i] = (btr[i >> 1] >> 1) + ((i & 1) << (log\
    \ - 1));\n\t\tlong dw = md.pow(md.inv(md.primitiveRoot()), (md.MOD - 1) / (size\
    \ << 1));\n\n\t\twhile(n > 0) {\n\t\t\tlong inv2 = md.inv(2);\n\t\t\tlong t[]\
    \ = new long[size];\n\t\t\tfor(int i = 0; i < size; i ++) t[i] = md.mul(g.a[(i\
    \ << 1) | 0], g.a[(i << 1) | 1]);\n\t\t\tlong s[] = new long[size];\n\t\t\tif((n\
    \ & 1) != 0) {\n\t\t\t\tfor(int i : btr) {\n\t\t\t\t\ts[i] = md.sub(md.mul(f.a[i\
    \ << 1], g.a[(i << 1) | 1]), md.mul(f.a[(i << 1) | 1], g.a[i << 1]));\n\t\t\t\t\
    \ts[i] = md.mul(s[i], inv2);\n\t\t\t\t\tinv2 = md.mul(inv2, dw);\n\t\t\t\t}\n\t\
    \t\t}else {\n\t\t\t\tfor(int i = 0; i < size; i ++) {\n\t\t\t\t\ts[i] = md.add(md.mul(f.a[i\
    \ << 1], g.a[(i << 1) | 1]), md.mul(f.a[(i << 1) | 1], g.a[i << 1]));\n\t\t\t\t\
    \ts[i] = md.mul(s[i], inv2);\n\t\t\t\t}\n\t\t\t}\n\t\t\tf.a = s;\n\t\t\tg.a =\
    \ t;\n\t\t\tn >>= 1;\n\t\t\tif(n < size) break;\n\t\t\top.doublingEquals(f);\n\
    \t\t\top.doublingEquals(g);\n\t\t}\n\t\tp = op.butterflyInv(f);\n\t\tq = op.butterflyInv(g);\n\
    \t\treturn op.div(p, q).get((int)n);\n\t}\n\tpublic static final long calLinearRecurrence(final\
    \ FpsOperator op, Fps p, final Fps q, long n) {\n\t\tp = op.resize(p, q.size()\
    \ - 1);\n\t\twhile(n != 0) {\n\t\t\tFps q2 = new Fps(q);\n\t\t\tfor(int i = 1;\
    \ i < q2.size(); i += 2) q2.mul(i, -1l);\n\t\t\tFps s = op.mul(p, q2);\n\t\t\t\
    Fps t = op.mul(q, q2);\n\t\t\tfor(int i = (int)(n & 1); i < s.size(); i += 2)\
    \ p.a[i >> 1] = s.a[i];\n\t\t\tfor(int i = 0; i < t.size(); i += 2) q.a[i >> 1]\
    \ = t.a[i];\n\t\t\tn >>= 1;\n\t\t}\n\t\treturn p.a[0];\n\t}\n}"
  dependsOn:
  - library/Mod.java
  - library/Convolution.java
  - library/Fps.java
  isVerificationFile: false
  path: library/Kitamasa.java
  requiredBy: []
  timestamp: '2022-11-02 11:31:02+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/Kitamasa.java
layout: document
redirect_from:
- /library/library/Kitamasa.java
- /library/library/Kitamasa.java.html
title: library/Kitamasa.java
---
