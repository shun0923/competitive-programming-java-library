---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Fps_exp_test.java
    title: library/Fps_exp_test.java
  - icon: ':heavy_check_mark:'
    path: library/Fps_inv_test.java
    title: library/Fps_inv_test.java
  - icon: ':heavy_check_mark:'
    path: library/Fps_log_test.java
    title: library/Fps_log_test.java
  - icon: ':heavy_check_mark:'
    path: library/Fps_mul_test.java
    title: library/Fps_mul_test.java
  - icon: ':heavy_check_mark:'
    path: library/Fps_pow_test.java
    title: library/Fps_pow_test.java
  - icon: ':x:'
    path: library/Fps_sqrt_test.java
    title: library/Fps_sqrt_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':question:'
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\nimport library.Mod;\nimport library.Convolution;\n\nclass\
    \ CnvFpsOperator extends FpsOperator {\n\tConvolution cnv;\n\tCnvFpsOperator(Convolution\
    \ cnv) { super(cnv.md); this.cnv = cnv; }\n\n\tpublic final Fps butterfly(final\
    \ Fps f) { return butterfly(f, f.a.length); }\n\tpublic final Fps butterfly(final\
    \ Fps f, int l) { return butterflyEquals(resize(f, l)); }\n\tpublic final Fps\
    \ butterflyEquals(final Fps f) { cnv.butterfly(f.a); return f; }\n\tpublic final\
    \ Fps butterflyInv(final Fps f) { return butterflyInv(f, f.a.length); }\n\tpublic\
    \ final Fps butterflyInv(final Fps f, int l) { return butterflyInvEquals(resize(f,\
    \ l)); }\n\tpublic final Fps butterflyInvEquals(final Fps f) { cnv.butterflyInv(f.a);\
    \ return f; }\n\n\tpublic final Fps mul(final Fps f, final Fps g, final int l)\
    \ { return new Fps(this, cnv.cnv(f.a, g.a, l)); }\n\tpublic final Fps inv(final\
    \ Fps f, final int l) {\n\t\tif(f.get(0) == 0) return null;\n\t\tif(l == 0) return\
    \ zero(0);\n\t\tint m = 1;\n\t\tFps g = zero(l);\n\t\tg.a[0] = md.inv(f.a[0]);\n\
    \t\tlong inv4 = md.inv(4);\n\t\tlong div = md.mod(-1);\n\t\twhile(m < l) {\n\t\
    \t\tm <<= 1;\n\t\t\tFps f1 = butterfly(f, m);\n\t\t\tFps g1 = butterfly(g, m);\n\
    \t\t\tmulElemwiseEquals(f1, g1);\n\t\t\tbutterflyInvEquals(f1);\n\t\t\tm >>= 1;\n\
    \t\t\trshiftEquals(f1, m);\n\t\t\tbutterflyEquals(f1);\n\t\t\tmulElemwiseEquals(f1,\
    \ g1);\n\t\t\tbutterflyInvEquals(f1);\n\t\t\tdiv = md.mul(div, inv4);\n\t\t\t\
    f1 = resize(f1, Math.min(l - m, m));\n\t\t\tmulEquals(f1, div);\n\t\t\tSystem.arraycopy(f1.a,\
    \ 0, g.a, m, f1.a.length);\n\t\t\tm <<= 1;\n\t\t}\n\t\treturn g;\n\t}\n\tpublic\
    \ final Fps div(final Fps f, final Fps g, final int l) { return mul(f, inv(g,\
    \ l), l); }\n\tprotected final Fps calPow(final Fps f, final long n, final int\
    \ l) {\n\t\treturn mulEquals(expEquals(mulEquals(log(div(f, f.a[0]), l), n)),\
    \ md.pow(f.a[0], n));\n\t}\n\tpublic final Fps exp(Fps f, final int l) {\n\t\t\
    if(f.get(0) != 0) return null;\n\t\tif(l == 0) return zero(0);\n\t\tint size =\
    \ 1;\n\t\tFps h = one(l);\n\t\tFps diff = diff(f);\n\t\tFps inv = one(l << 1);\n\
    \t\tFps btfInv = zero(0);\n\t\tlong inv4 = md.inv(4);\n\t\tlong invLen2 = md.mod(-1);\n\
    \t\tlong inv2 = md.inv(2);\n\t\tlong invLen = 1;\n\t\twhile(size < l) {\n\t\t\t\
    Fps btf = resize(h, size << 1);\n\t\t\tbutterflyEquals(btf);\n\n\t\t\tif(size\
    \ > 1) {\n\t\t\t\tFps g = mulElemwise(btf, btfInv, size);\n\t\t\t\tbutterflyInvEquals(g);\n\
    \t\t\t\tsize >>= 1;\n\t\t\t\trshiftEquals(g, size);\n\t\t\t\tbutterflyEquals(g);\n\
    \t\t\t\tmulElemwiseEquals(g, btfInv);\n\t\t\t\tbutterflyInvEquals(g);\n\t\t\t\t\
    invLen2 = md.mul(invLen2, inv4);\n\t\t\t\tmulEquals(g, invLen2);\n\t\t\t\tSystem.arraycopy(g.a,\
    \ 0, inv.a, size, size);\n\t\t\t\tsize <<= 1;\n\t\t\t}\n\n\t\t\tFps t = diff(h,\
    \ size);\n\t\t\t{\n\t\t\t\tFps r = resize(diff, size);\n\t\t\t\tr.a[size - 1]\
    \ = 0;\n\t\t\t\tbutterflyEquals(r);\n\t\t\t\tmulElemwiseEquals(r, btf);\n\t\t\t\
    \tbutterflyInvEquals(r);\n\t\t\t\tmulEquals(r, - invLen);\n\t\t\t\taddEquals(r,\
    \ t);\n\t\t\t\tt = lshift(r, 1, size);\n\t\t\t\tt.a[0] = r.a[size - 1];\n\t\t\t\
    }\n\t\t\tsize <<= 1;\n\n\t\t\tt = butterfly(resize(t, size));\n\t\t\tbtfInv =\
    \ butterfly(resize(inv, size));\n\t\t\tmulElemwiseEquals(t, btfInv);\n\t\t\tbutterflyInvEquals(t);\n\
    \t\t\tsize >>= 1;\n\t\t\tinvLen = md.mul(invLen, inv2);\n\t\t\tmulEquals(t, invLen);\n\
    \n\t\t\tt = rshift(integ(lshift(resize(t, size), size - 1)), size);\n\t\t\tFps\
    \ v = zero(size << 1);\n\t\t\tif(size < f.a.length) System.arraycopy(f.a, size,\
    \ v.a, 0, Math.min(f.a.length - size, size));\n\t\t\tsubEquals(v, t);\n\n\t\t\t\
    butterflyEquals(v);\n\t\t\tmulElemwiseEquals(v, btf);\n\t\t\tbutterflyInvEquals(v);\n\
    \t\t\tv = resize(v, Math.min(size, l - size));\n\t\t\tmulEquals(v, invLen);\n\t\
    \t\tSystem.arraycopy(v.a, 0, h.a, size, v.a.length);\n\t\t\tsize <<= 1;\n\t\t\
    }\n\t\treturn h;\n\t}\n\tprotected final Fps calSqrt(final Fps f, final int l)\
    \ {\n\t\tlong sqrt = md.sqrt(f.a[0]);\n\t\tif(sqrt == -1) return null;\n\t\tint\
    \ size = 1;\n\t\tFps h = constant(sqrt, l);\n\t\tFps inv = constant(md.inv(sqrt),\
    \ l << 1);\n\t\tFps btfInv = zero(0);\n\t\tlong inv4 = md.inv(4);\n\t\tlong invLen2\
    \ = md.mod(-1);\n\t\tlong inv2 = md.inv(2);\n\t\tlong invLen = inv2;\n\t\twhile(size\
    \ < l) {\n\t\t\tFps btf = resize(h, size << 1);\n\t\t\tbutterflyEquals(btf);\n\
    \n\t\t\tif(size > 1) {\n\t\t\t\tFps g = mulElemwise(btf, btfInv);\n\t\t\t\tbutterflyInvEquals(g);\n\
    \t\t\t\tsize >>= 1;\n\t\t\t\trshiftEquals(g, size);\n\t\t\t\tbutterflyEquals(g);\n\
    \t\t\t\tmulElemwiseEquals(g, btfInv);\n\t\t\t\tbutterflyInvEquals(g);\n\t\t\t\t\
    invLen2 = md.mul(invLen2, inv4);\n\t\t\t\tmulEquals(g, invLen2);\n\t\t\t\tSystem.arraycopy(g.a,\
    \ 0, inv.a, size, size);\n\t\t\t\tsize <<= 1;\n\t\t\t}\n\n\t\t\tFps t = mulElemwise(btf,\
    \ btf);\n\t\t\tbutterflyInvEquals(t);\n\t\t\tmulEquals(t, - invLen);\n\t\t\trshiftEquals(t,\
    \ size);\n\t\t\tfor(int i = 0, m = Math.min(size, f.a.length - size); i < m; i\
    \ ++) addEquals(t, i, f.a[i + size]);\n\n\t\t\tbutterflyEquals(t);\n\t\t\tbtfInv\
    \ = butterfly(resize(inv, size << 1));\n\t\t\tmulElemwiseEquals(t, btfInv);\n\t\
    \t\tbutterflyInvEquals(t);\n\t\t\tt = resize(t, Math.min(size, l - size));\n\t\
    \t\tinvLen = md.mul(invLen, inv2);\n\t\t\tmulEquals(t, invLen);\n\t\t\tSystem.arraycopy(t.a,\
    \ 0, h.a, size, t.a.length);\n\t\t\tsize <<= 1;\n\t\t}\n\t\treturn h;\n\t}\n}\n\
    \nclass NaiveFpsOperator extends FpsOperator {\n\tNaiveFpsOperator(Mod md) { super(md);\
    \ }\n\tpublic final Fps mul(final Fps f, final Fps g, final int l) { return naiveMul(f,\
    \ g, l); }\n\tpublic final Fps inv(final Fps f, final int l) { return naiveInv(f,\
    \ l); }\n\tpublic final Fps div(final Fps f, final Fps g, final int l) { return\
    \ naiveDiv(f, g, l); }\n\tprotected final Fps calPow(final Fps f, final long n,\
    \ final int l) { return calNaivePow(f, n, l); }\n\tpublic final Fps exp(final\
    \ Fps f, final int l) { return naiveExp(f, l); }\n\tprotected final Fps calSqrt(final\
    \ Fps f, final int l) { return calNaiveSqrt(f, l); }\n}\n\nabstract class FpsOperator\
    \ {\n\tpublic final Mod md;\n\n\tFpsOperator(Mod md) { this.md = md; }\n\n\tpublic\
    \ final Fps zero(final int l) { return new Fps(this, l); }\n\tpublic final Fps\
    \ one(final int l) { return setEquals(new Fps(this, l), 0, 1); }\n\tpublic final\
    \ Fps constant(final long c, final int l) { return setEquals(new Fps(this, l),\
    \ 0, c); }\n\n\tpublic final long eval(final Fps f, final long x) {\n\t\tlong\
    \ ans = 0;\n\t\tlong pow = 1;\n\t\tfor(int i = 0; i < f.a.length; i ++) {\n\t\t\
    \tans = md.add(ans, md.mul(f.a[i], pow));\n\t\t\tpow = md.mul(pow, x);\n\t\t}\n\
    \t\treturn ans;\n\t}\n\n\tpublic final Fps resize(final Fps f, final int l) {\
    \ return new Fps(f, l); }\n\tpublic final Fps resizeEquals(final Fps f, final\
    \ int l) { f.a = resize(f, l).a; return f; }\n\tpublic final Fps shrink(final\
    \ Fps f) {\n\t\tfor(int i = f.a.length - 1; i >= 0; i --) if(f.a[i] != 0) return\
    \ resize(f, i + 1);\n\t\treturn zero(0);\n\t}\n\tpublic final Fps shrink(final\
    \ Fps f, final int l) { return shrink(l > f.a.length ? f : resize(f, l)); }\n\t\
    public final Fps lshift(final Fps f, final int k) { return lshift(f, k, Math.max(0,\
    \ f.a.length + k)); }\n\tpublic final Fps lshift(final Fps f, final int k, final\
    \ int l) {\n\t\tif(k < 0) return rshift(f, - k, l);\n\t\tFps g = zero(l);\n\t\t\
    if(l > k) System.arraycopy(f.a, 0, g.a, k, Math.min(f.a.length, l - k));\n\t\t\
    return g;\n\t}\n\tpublic final Fps lshiftEquals(final Fps f, final int k) { f.a\
    \ = lshift(f, k, f.a.length).a; return f; }\n\tpublic final Fps rshift(final Fps\
    \ f, final int k) { return rshift(f, k, Math.max(0, f.a.length - k)); }\n\tpublic\
    \ final Fps rshift(final Fps f, final int k, final int l) {\n\t\tif(k < 0) return\
    \ lshift(f, - k, l);\n\t\tFps g = zero(l);\n\t\tif(f.a.length > k) System.arraycopy(f.a,\
    \ k, g.a, 0, Math.min(f.a.length - k, l));\n\t\treturn g;\n\t}\n\tpublic final\
    \ Fps rshiftEquals(final Fps f, final int k) { f.a = rshift(f, k, f.a.length).a;\
    \ return f; }\n\tpublic final Fps reverse(final Fps f) { return reverseEquals(new\
    \ Fps(f)); }\n\tpublic final Fps reverseEquals(final Fps f) {\n\t\tfor(int i =\
    \ 0, j = f.a.length - 1; i < j; i ++, j --) {\n\t\t\tlong tmp = f.a[i];\n\t\t\t\
    f.a[i] = f.a[j];\n\t\t\tf.a[j] = tmp;\n\t\t}\n\t\treturn f;\n\t}\n\tpublic final\
    \ Fps negate(final Fps f) { return negate(f, f.a.length); }\n\tpublic final Fps\
    \ negate(final Fps f, final int l) { return negateEquals(resize(f, l)); }\n\t\
    public final Fps negateEquals(final Fps f) {\n\t\tfor(int i = 0; i < f.a.length;\
    \ i ++) f.a[i] = md.mod(- f.a[i]);\n\t\treturn f;\n\t}\n\n\tpublic final Fps op(final\
    \ Fps f, final int i, final LongUnaryOperator op) { return op(f, i, op, Math.max(f.a.length,\
    \ i + 1)); }\n\tpublic final Fps op(final Fps f, final int i, final LongUnaryOperator\
    \ op, final int l) { return opEquals(resize(f, l), i, op); }\n\tpublic final Fps\
    \ opEquals(final Fps f, final int i, final LongUnaryOperator op) { f.a[i] = md.mod(op.applyAsLong(f.a[i]));\
    \ return f; }\n\tpublic final Fps set(final Fps f, final int i, final long x)\
    \ { return set(f, i, x, Math.max(f.a.length, i + 1)); }\n\tpublic final Fps set(final\
    \ Fps f, final int i, final long x, final int l) { return setEquals(resize(f,\
    \ l), i, x); }\n\tpublic final Fps setEquals(final Fps f, final int i, final long\
    \ x) { f.a[i] = md.mod(x); return f; }\n\tpublic final Fps add(final Fps f, final\
    \ int i, final long x) { return add(f, i, x, Math.max(f.a.length, i + 1)); }\n\
    \tpublic final Fps add(final Fps f, final int i, final long x, final int l) {\
    \ return addEquals(resize(f, l), i, x); }\n\tpublic final Fps addEquals(final\
    \ Fps f, final int i, final long x) { f.a[i] = md.add(f.a[i], x); return f; }\n\
    \tpublic final Fps sub(final Fps f, final int i, final long x) { return sub(f,\
    \ i, x, Math.max(f.a.length, i + 1)); }\n\tpublic final Fps sub(final Fps f, final\
    \ int i, final long x, final int l) { return subEquals(resize(f, l), i, x); }\n\
    \tpublic final Fps subEquals(final Fps f, final int i, final long x) { f.a[i]\
    \ = md.sub(f.a[i], x); return f; }\n\tpublic final Fps mul(final Fps f, final\
    \ int i, final long x) { return mul(f, i, x, Math.max(f.a.length, i + 1)); }\n\
    \tpublic final Fps mul(final Fps f, final int i, final long x, final int l) {\
    \ return mulEquals(resize(f, l), i, x); }\n\tpublic final Fps mulEquals(final\
    \ Fps f, final int i, final long x) { f.a[i] = md.mul(f.a[i], x); return f; }\n\
    \tpublic final Fps div(final Fps f, final int i, final long x) { return div(f,\
    \ i, x, Math.max(f.a.length, i + 1)); }\n\tpublic final Fps div(final Fps f, final\
    \ int i, final long x, final int l) { return divEquals(resize(f, l), i, x); }\n\
    \tpublic final Fps divEquals(final Fps f, final int i, final long x) { f.a[i]\
    \ = md.div(f.a[i], x); return f; }\n\n\tpublic final Fps op(final Fps f, final\
    \ LongUnaryOperator op) { return op(f, op, f.a.length); }\n\tpublic final Fps\
    \ op(final Fps f, final LongUnaryOperator op, final int l) { return opEquals(resize(f,\
    \ l), op); }\n\tpublic final Fps opEquals(final Fps f, final LongUnaryOperator\
    \ op) { for(int i = 0; i < f.a.length; i ++) opEquals(f, i, op); return f; }\n\
    \tpublic final Fps mul(final Fps f, final long x) { return mul(f, x, f.a.length);\
    \ }\n\tpublic final Fps mul(final Fps f, final long x, final int l) { return mulEquals(resize(f,\
    \ l), x); }\n\tpublic final Fps mulEquals(final Fps f, final long x) { for(int\
    \ i = 0; i < f.a.length; i ++) f.a[i] = md.mul(f.a[i], x); return f; }\n\tpublic\
    \ final Fps div(final Fps f, final long x) { return div(f, x, f.a.length); }\n\
    \tpublic final Fps div(final Fps f, final long x, final int l) { return divEquals(resize(f,\
    \ l), x); }\n\tpublic final Fps divEquals(final Fps f, final long x) { return\
    \ mulEquals(f, md.inv(x)); }\n\n\tpublic final Fps add(final Fps f, final Fps\
    \ g) { return add(f, g, Math.max(f.a.length, g.a.length)); }\n\tpublic final Fps\
    \ add(final Fps f, final Fps g, final int l) { return addEquals(resize(f, l),\
    \ g); }\n\tpublic final Fps addEquals(final Fps f, final Fps g) {\n\t\tfor(int\
    \ i = 0, l = Math.min(f.a.length, g.a.length); i < l; i ++) addEquals(f, i, g.a[i]);\n\
    \t\treturn f;\n\t}\n\tpublic final Fps sub(final Fps f, final Fps g) { return\
    \ sub(f, g, Math.max(f.a.length, g.a.length)); }\n\tpublic final Fps sub(final\
    \ Fps f, final Fps g, final int l) { return subEquals(resize(f, l), g); }\n\t\
    public final Fps subEquals(final Fps f, final Fps g) {\n\t\tfor(int i = 0, l =\
    \ Math.min(f.a.length, g.a.length); i < l; i ++) subEquals(f, i, g.a[i]);\n\t\t\
    return f;\n\t}\n\tpublic final Fps mulElemwise(final Fps f, final Fps g) { return\
    \ mulElemwise(f, g, Math.min(f.a.length, g.a.length)); }\n\tpublic final Fps mulElemwise(final\
    \ Fps f, final Fps g, final int l) { return mulElemwiseEquals(resize(f, l), g);\
    \ }\n\tpublic final Fps mulElemwiseEquals(final Fps f, final Fps g) {\n\t\tfor(int\
    \ i = 0, l = Math.min(f.a.length, g.a.length); i < l; i ++) mulEquals(f, i, g.a[i]);\n\
    \t\tfor(int i = g.a.length; i < f.a.length; i ++) f.a[i] = 0;\n\t\treturn f;\n\
    \t}\n\n\tpublic final Fps mul(final Fps f, final Fps g) { return mul(f, g, f.a.length\
    \ + g.a.length - 1); }\n\tpublic abstract Fps mul(final Fps f, final Fps g, final\
    \ int l);\n\tpublic final Fps mulEquals(final Fps f, final Fps g) { f.a = mul(f,\
    \ g, f.a.length).a; return f; }\n\tpublic final Fps mulShrink(final Fps f, final\
    \ Fps g, final int l) { return shrink(mul(f, g, Math.min(l, f.a.length + g.a.length\
    \ - 1))); }\n\tpublic final Fps inv(final Fps f) { return inv(f, f.a.length);\
    \ }\n\tpublic abstract Fps inv(final Fps f, final int l);\n\tpublic final Fps\
    \ invEquals(final Fps f) { f.a = inv(f, f.a.length).a; return f; }\n\tpublic final\
    \ Fps div(final Fps f, final Fps g) { return div(f, g, f.a.length); }\n\tpublic\
    \ abstract Fps div(final Fps f, final Fps g, final int l);\n\tpublic final Fps\
    \ divEquals(final Fps f, final Fps g) { f.a = div(f, g).a; return f; }\n\tpublic\
    \ final Fps divfloor(final Fps f, final Fps g) { return divfloor(f, g, Math.max(0,\
    \ f.a.length - g.a.length + 1)); }\n\tpublic final Fps divfloor(final Fps f, final\
    \ Fps g, final int l) {\n\t\treturn resize(reverse(div(reverse(f), reverse(g),\
    \ Math.max(0, f.a.length - g.a.length + 1))), l);\n\t}\n\tpublic final Fps divfloorEquals(final\
    \ Fps f, final Fps g) { f.a = divfloor(f, g, f.a.length).a; return f; }\n\tpublic\
    \ final Fps mod(final Fps f, final Fps g) { return mod(f, g, Math.min(f.a.length,\
    \ g.a.length - 1)); }\n\tpublic final Fps mod(final Fps f, final Fps g, final\
    \ int l) { return sub(f, mulShrink(divfloor(f, g), g, l), l); }\n\tpublic final\
    \ Fps modEquals(final Fps f, final Fps g) { f.a = mod(f, g, f.a.length).a; return\
    \ f; }\n\tpublic final Fps modShrink(final Fps f, final Fps g, final int l) {\
    \ return shrink(mod(f, g, Math.min(l, Math.min(f.a.length, g.a.length - 1))));\
    \ }\n\tpublic final Fps pow(final Fps f, final long k) { return pow(f, k, f.a.length);\
    \ }\n\tpublic final Fps pow(final Fps f, final long n, final int l) {\n\t\tif(l\
    \ == 0) return zero(0);\n\t\tif(n == 0) return one(l);\n\t\tif(n == 1) return\
    \ resize(f, l);\n\t\tif(n == 2) return mul(f, f, l);\n\t\tif(f.get(0) == 0) {\n\
    \t\t\tint i = f.lowest();\n\t\t\tif(n < 0) return null;\n\t\t\tif(n > (l - 1)\
    \ / i) return zero(l);\n\t\t\treturn lshift(calPow(rshift(f, i), n, l - (int)n\
    \ * i), (int)n * i);\n\t\t}\n\t\tif(n < 0) return invEquals(calPow(f, - n, l));\n\
    \t\treturn calPow(f, n, l);\n\t}\n\tprotected abstract Fps calPow(final Fps f,\
    \ final long k, final int l);\n\tpublic final Fps powEquals(final Fps f, final\
    \ long k) { f.a = pow(f, k).a; return f; }\n\tpublic final Fps powShrink(final\
    \ Fps f, final long k, final int l) {\n\t\treturn f.a.length == 0 ? zero(0) :\
    \ shrink(pow(f, k, k > (l - 1) / (f.a.length - 1) ? l : (f.a.length - 1) * (int)\
    \ k + 1));\n\t}\n\n\tpublic final Fps naiveMul(final Fps f, final Fps g) { return\
    \ naiveMul(f, g, f.a.length + g.a.length - 1); }\n\tpublic final Fps naiveMul(Fps\
    \ f, Fps g, final int l) {\n\t\tf = shrink(f, l);\n\t\tg = shrink(g, l);\n\t\t\
    Fps h = zero(l);\n\t\tfor(int i = 0; i < l; i ++) {\n\t\t\tlong sum = 0;\n\t\t\
    \tfor(int j = Math.max(0, i - g.a.length + 1), k = i - j, m = Math.min(f.a.length,\
    \ i + 1); j < m; j ++, k --) {\n\t\t\t\tsum = md.add(sum, md.mul(f.a[j], g.a[k]));\n\
    \t\t\t}\n\t\t\th.a[i] = sum;\n\t\t}\n\t\treturn h;\n\t}\n\tpublic final Fps naiveMulEquals(final\
    \ Fps f, final Fps g) { f.a = naiveMul(f, g, f.a.length).a; return f; }\n\tpublic\
    \ final Fps naiveMulShrink(final Fps f, final Fps g, final int l) { return shrink(naiveMul(f,\
    \ g, Math.min(l, f.a.length + g.a.length - 1))); }\n\tpublic final Fps naiveInv(final\
    \ Fps f) { return naiveInv(f, f.a.length); }\n\tpublic final Fps naiveInv(final\
    \ Fps f, final int l) { return naiveDiv(one(1), f, l); }\n\tpublic final Fps naiveInvEquals(final\
    \ Fps f) { f.a = naiveInv(f).a; return f; }\n\tpublic final Fps naiveDiv(final\
    \ Fps f, final Fps g) { return naiveDiv(f, g, f.a.length); }\n\tpublic final Fps\
    \ naiveDiv(Fps f, Fps g, final int l) {\n\t\tif(g.get(0) == 0) return null;\n\t\
    \tif(l == 0) return zero(0);\n\t\tf = shrink(f, l);\n\t\tg = shrink(g, l);\n\t\
    \tFps h = resize(f, l);\n\t\tlong div = md.inv(g.a[0]);\n\t\tfor(int i = 0; i\
    \ < l; i ++) {\n\t\t\tlong sum = 0;\n\t\t\tfor(int j = Math.max(0, i - g.a.length\
    \ + 1), k = i - j; k > 0; j ++, k --) {\n\t\t\t\tsum = md.add(sum, md.mul(h.a[j],\
    \ g.a[k]));\n\t\t\t}\n\t\t\th.a[i] = md.mul(md.sub(h.a[i], sum), div);\n\t\t}\n\
    \t\treturn h;\n\t}\n\tpublic final Fps naiveDivEquals(final Fps f, final Fps g)\
    \ { f.a = naiveDiv(f, g).a; return f; }\n\tpublic final Fps naivePow(final Fps\
    \ f, final long n) { return naivePow(f, n, f.a.length); }\n\tpublic final Fps\
    \ naivePow(Fps f, long n, final int l) {\n\t\tif(l == 0) return zero(0);\n\t\t\
    if(n == 0) return one(l);\n\t\tif(n == 1) return resize(f, l);\n\t\tif(n == 2)\
    \ return mul(f, f, l);\n\t\tif(f.get(0) == 0) {\n\t\t\tint i = f.lowest();\n\t\
    \t\tif(n < 0) return null;\n\t\t\tif(n > (l - 1) / i) return zero(l);\n\t\t\t\
    return lshift(calNaivePow(rshift(f, i), n, l - (int)n * i), (int)n * i);\n\t\t\
    }\n\t\tif(n < 0) return naiveInvEquals(calNaivePow(f, - n, l));\n\t\treturn calNaivePow(f,\
    \ n, l);\n\t}\n\tprotected final Fps calNaivePow(Fps f, long n, final int l) {\n\
    \t\tf = shrink(f, l);\n\t\tlong inv[] = md.invs(l);\n\t\tlong div = md.inv(f.a[0]);\n\
    \t\tfor(int i = 0; i < l; i ++) inv[i] = md.mul(inv[i], div);\n\t\tFps g = constant(md.pow(f.a[0],\
    \ n), l);\n\t\tfor(int i = 1; i < l; i ++) {\n\t\t\tlong sum = 0;\n\t\t\tfor(int\
    \ j = 1, k = i - 1, m = Math.min(i, f.a.length - 1); j <= m; j ++, k --) {\n\t\
    \t\t\tsum = md.add(sum, md.mul((n + 1) * j - i, f.a[j], g.a[k]));\n\t\t\t}\n\t\
    \t\tg.a[i] = md.mul(sum, inv[i]);\n\t\t}\n\t\treturn g;\n\t}\n\tpublic final Fps\
    \ naivePowEquals(final Fps f, final long n) { f.a = naivePow(f, n).a; return f;\
    \ }\n\tpublic final Fps binaryPow(final Fps f, final long n) { return binaryPow(f,\
    \ n, f.a.length); }\n\tpublic final Fps binaryPow(final Fps f, long n, final int\
    \ l) {\n\t\tif(l == 0) return zero(0);\n\t\tif(n == 0) return one(l);\n\t\tif(n\
    \ == 1) return resize(f, l);\n\t\tif(n == 2) return mul(f, f, l);\n\t\tif(f.get(0)\
    \ == 0) {\n\t\t\tint i = f.lowest();\n\t\t\tif(n < 0) return null;\n\t\t\tif(n\
    \ > (l - 1) / i) return zero(l);\n\t\t\treturn lshift(binaryPow(rshift(f, i),\
    \ n, l - (int)n * i), (int)n * i);\n\t\t}\n\t\tif(n < 0) return invEquals(binaryPow(f,\
    \ - n, l));\n\t\tFps g = shrink(f, l);\n\t\tFps h = one(1);\n\t\twhile(true) {\n\
    \t\t\tif((n & 1) != 0) h = mulShrink(h, g, l);\n\t\t\tn >>= 1;\n\t\t\tif(n ==\
    \ 0) return resize(h, l);\n\t\t\tg = mulShrink(g, g, l);\n\t\t}\n\t}\n\tpublic\
    \ final Fps binaryPowEquals(final Fps f, final long n) { f.a = binaryPow(f, n).a;\
    \ return f; }\n\n\t// f<-f*(1+cx^d) // O(N)\n\tpublic final Fps mulSparseEquals(final\
    \ Fps f, final int d, long c) {\n\t\tif(c == 1) for(int i = f.a.length - 1; i\
    \ >= d; i --) addEquals(f, i, f.a[i - d]);\n\t\telse if(c == -1) for(int i = f.a.length\
    \ - 1; i >= d; i --) subEquals(f, i, f.a[i - d]);\n\t\telse {\n\t\t\tc = md.mod(c);\n\
    \t\t\tfor(int i = f.a.length - 1; i >= d; i --) addEquals(f, i, md.mul(f.a[i -\
    \ d], c));\n\t\t}\n\t\treturn f;\n\t}\n\t// f<-f/(1+cx^d) // O(N)\n\tpublic final\
    \ Fps divSparseEquals(final Fps f, final int d, long c) {\n\t\tif(c == 1) for(int\
    \ i = d; i < f.a.length; i ++) subEquals(f, i, f.a[i - d]);\n\t\telse if(c ==\
    \ -1) for(int i = d; i < f.a.length; i ++) addEquals(f, i, f.a[i - d]);\n\t\t\
    else {\n\t\t\tc = md.mod(c);\n\t\t\tfor(int i = d; i < f.a.length; i ++) subEquals(f,\
    \ i, md.mul(f.a[i - d], c));\n\t\t}\n\t\treturn f;\n\t}\n\n\tpublic final Fps\
    \ diff(final Fps f) { return diff(f, Math.max(0, f.a.length - 1)); }\n\tpublic\
    \ final Fps diff(final Fps f, final int l) {\n\t\tFps g = zero(l);\n\t\tfor(int\
    \ i = 1, m = Math.min(l + 1, f.a.length); i < m; i ++) g.a[i - 1] = md.mul(f.a[i],\
    \ i);\n\t\treturn g;\n\t}\n\tpublic final Fps diffEquals(final Fps f) { f.a =\
    \ diff(f, f.a.length).a; return f; }\n\tpublic final Fps integ(final Fps f) {\
    \ return integ(f, f.a.length + 1); }\n\tpublic final Fps integ(final Fps f, final\
    \ int l) {\n\t\tif(l == 0) return zero(0);\n\t\tFps g = zero(l);\n\t\tlong inv[]\
    \ = md.invs(Math.min(l - 1, f.a.length));\n\t\tfor(int i = 1; i < inv.length;\
    \ i ++) g.a[i] = md.mul(f.a[i - 1], inv[i]);\n\t\treturn g;\n\t}\n\tpublic final\
    \ Fps integEquals(final Fps f) { f.a = integ(f, f.a.length).a; return f; }\n\t\
    public final Fps log(final Fps f) { return log(f, f.a.length); }\n\tpublic final\
    \ Fps log(final Fps f, final int l) {\n\t\tif(f.get(0) != 1) return null;\n\t\t\
    return integEquals(divEquals(diff(f, l), f));\n\t}\n\tpublic final Fps logEquals(final\
    \ Fps f) { f.a = log(f).a; return f; }\n\tpublic final Fps exp(final Fps f) {\
    \ return exp(f, f.a.length); }\n\tpublic abstract Fps exp(final Fps f, final int\
    \ l);\n\tpublic final Fps expEquals(final Fps f) { f.a = exp(f).a; return f; }\n\
    \tpublic final Fps sqrt(final Fps f) { return sqrt(f, f.a.length); }\n\tpublic\
    \ final Fps sqrt(final Fps f, final int l) {\n\t\tif(l == 0) return zero(0);\n\
    \t\tif(f.get(0) == 0) {\n\t\t\tint i = f.lowest();\n\t\t\tif(i == f.a.length)\
    \ return zero(l);\n\t\t\tif((i & 1) != 0) return null;\n\t\t\tif(i << 1 >= l)\
    \ return zero(l);\n\t\t\tFps g = calSqrt(rshift(f, i), l - (i >> 1));\n\t\t\t\
    return g == null ? null : lshift(g, i >> 1);\n\t\t}\n\t\treturn calSqrt(f, l);\n\
    \t}\n\tprotected abstract Fps calSqrt(final Fps f, final int l);\n\tpublic final\
    \ Fps sqrtEquals(final Fps f) { f.a = sqrt(f).a; return f; }\n\n\tpublic final\
    \ Fps naiveExp(final Fps f) { return naiveExp(f, f.a.length); }\n\tpublic final\
    \ Fps naiveExp(Fps f, final int l) {\n\t\tif(f.get(0) != 0) return null;\n\t\t\
    long inv[] = md.invs(l);\n\t\tf = shrink(f);\n\t\tFps g = one(l);\n\t\tfor(int\
    \ i = 1; i < l; i ++) {\n\t\t\tlong sum = 0;\n\t\t\tfor(int j = 1, k = i - 1,\
    \ m = Math.min(i, f.a.length - 1); j <= m; j ++, k --) {\n\t\t\t\tsum = md.add(sum,\
    \ md.mul(j, f.a[j], g.a[k]));\n\t\t\t}\n\t\t\tg.a[i] = md.mul(sum, inv[i]);\n\t\
    \t}\n\t\treturn g;\n\t}\n\tpublic final Fps naiveExpEquals(final Fps f) { f.a\
    \ = naiveExp(f).a; return f; }\n\tpublic final Fps naiveSqrt(final Fps f) { return\
    \ naiveSqrt(f, f.a.length); }\n\tpublic final Fps naiveSqrt(final Fps f, final\
    \ int l) {\n\t\tif(l == 0) return zero(0);\n\t\tif(f.get(0) == 0) {\n\t\t\tint\
    \ i = f.lowest();\n\t\t\tif(i == f.a.length) return zero(l);\n\t\t\tif((i & 1)\
    \ != 0) return null;\n\t\t\tif(i << 1 >= l) return zero(l);\n\t\t\tFps g = calNaiveSqrt(rshift(f,\
    \ i), l - (i >> 1));\n\t\t\treturn g == null ? null : lshift(g, i >> 1);\n\t\t\
    }\n\t\treturn calNaiveSqrt(f, l);\n\t}\n\tprotected final Fps calNaiveSqrt(final\
    \ Fps f, final int l) {\n\t\tFps g = resize(f, l);\n\t\tlong inv[] = md.invs(l);\n\
    \t\tlong sqrt = md.sqrt(g.a[0]);\n\t\tif(sqrt == -1) return null;\n\t\tlong div\
    \ = md.inv(sqrt);\n\t\tmulEquals(g, md.div(div, 2));\n\t\tg.a[0] = sqrt;\n\t\t\
    for(int i = 0; i < l; i ++) inv[i] = md.mul(inv[i], div);\n\t\tfor(int i = 1;\
    \ i < l; i ++) {\n\t\t\tlong sum = 0;\n\t\t\tfor(int j = 1, k = i - 1; j < i;\
    \ j ++, k --) {\n\t\t\t\tsum = md.add(sum, md.mul(j, g.a[j], g.a[k]));\n\t\t\t\
    }\n\t\t\tsubEquals(g, i, md.mul(sum, inv[i]));\n\t\t}\n\t\treturn g;\n\t}\n\t\
    public final Fps naiveSqrtEquals(final Fps f) { f.a = naiveSqrt(f).a; return f;\
    \ }\n\n\t// f <- 1/(1-f)=1+f+f^2+f^3+...=sum_{k=0}^inf f^k = 1/(1-f)\n\tpublic\
    \ final Fps geomSeries(final Fps f) { return geomSeries(f, f.a.length); }\n\t\
    public final Fps geomSeries(final Fps f, final int l) { return inv(add(negate(f),\
    \ 0, 1), l); }\n\tpublic final Fps geomSeriesEquals(final Fps f) { f.a = geomSeries(f).a;\
    \ return f; }\n\t// f <- (1-f^n)/(1-f)=1+f+f^2+...+f^(n-1)=sum_{k=0}^{n-1} f^k\
    \ = (f^n-1)/(f-1)\n\tpublic final Fps geomPartialSeries(final Fps f, final int\
    \ n) { return geomPartialSeries(f, n, f.a.length); }\n\tpublic final Fps geomPartialSeries(final\
    \ Fps f, final int n, final int l) { return div(sub(powShrink(f, n, l), 0, 1),\
    \ sub(f, 0, 1), l); }\n\tpublic final Fps geomPartialSeriesEquals(final Fps f,\
    \ final int n) { f.a = geomPartialSeries(f, n).a; return f; }\n\n\t// return f(g)\n\
    \tpublic final Fps composite(final Fps f, final Fps g) { return composite(f, g,\
    \ f.a.length); }\n\tpublic final Fps composite(Fps f, Fps g, final int l) {\n\t\
    \tif(l == 0) return zero(0);\n\t\tf = shrink(f);\n\t\tg = shrink(g);\n\t\tif(f.a.length\
    \ == 0) return zero(l);\n\t\tif(g.a.length == 0) return constant(f.a[0], l);\n\
    \t\tif(l == 1 || g.a.length == 1) return constant(eval(f, g.a[0]), l);\n\n\t\t\
    int l2 = (int)Math.min(l, (long)(f.a.length - 1) * (g.a.length - 1) + 1);\n\t\t\
    int m = Math.max((int)Math.ceil(Math.sqrt(l2)), 2);\n\t\twhile(l2 > m * m) m ++;\n\
    \t\tFps pow[] = new Fps[m + 1];\n\t\tpow[0] = one(1);\n\t\tfor(int i = 1; i <=\
    \ m; i ++) pow[i] = mulShrink(pow[i - 1], g, l);\n\n\t\tFps pow2[] = new Fps[m];\n\
    \t\tpow2[0] = one(1);\n\t\tfor(int i = 1; i < m; i ++) pow2[i] = mulShrink(pow2[i\
    \ - 1], pow[m], l);\n\n\t\tFps fg[] = new Fps[m];\n\t\tfor(int i = 0; i < m; i\
    \ ++) {\n\t\t\tfg[i] = zero(l);\n\t\t\tfor(int j = 0; j < l; j ++) {\n\t\t\t\t\
    long sum = 0;\n\t\t\t\tfor(int k = 0, k2 = i * m, m2 = Math.min((i + 1) * m, f.a.length);\
    \ k2 < m2; k ++, k2 ++) {\n\t\t\t\t\tif(j < pow[k].a.length) sum = md.add(sum,\
    \ md.mul(f.a[k2], pow[k].a[j]));\n\t\t\t\t}\n\t\t\t\tfg[i].a[j] = sum;\n\t\t\t\
    }\n\t\t}\n\n\t\tFps h = zero(l);\n\t\tfor(int i = 0; i < m; i ++) addEquals(h,\
    \ mulShrink(fg[i], pow2[i], l));\n\t\treturn h;\n\t}\n\tpublic final Fps compositeEquals(final\
    \ Fps f, final Fps g) { f.a = composite(f, g).a; return f; }\n\t// return f(x+c)\n\
    \tpublic final Fps addComposite(final Fps f, final long c) { return addComposite(f,\
    \ c, f.a.length); }\n\tpublic final Fps addComposite(final Fps f, final long c,\
    \ final int l) {\n\t\tFps h = shrink(f, l);\n\t\tfor(int i = 0; i < h.a.length;\
    \ i ++) mulEquals(h, i, md.fact(i));\n\t\treverseEquals(h);\n\t\tFps g = one(h.a.length);\n\
    \t\tfor(int i = 1; i < g.a.length; i ++) g.a[i] = md.div(md.mul(g.a[i - 1], c),\
    \ i);\n\t\treverseEquals(mulEquals(h, g));\n\t\tfor(int i = 0; i < h.a.length;\
    \ i ++) mulEquals(h, i, md.invFact(i));\n\t\treturn resize(h, l);\n\t}\n\tpublic\
    \ final Fps addCompositeEquals(final Fps f, final long c) { f.a = addComposite(f,\
    \ c).a; return f; }\n\t// return f(cx)\n\t// O(N)\n\tpublic final Fps mulComposite(final\
    \ Fps f, final long c) { return mulComposite(f, c, f.a.length); }\n\tpublic final\
    \ Fps mulComposite(final Fps f, final long c, final int l) { return mulCompositeEquals(resize(f,\
    \ l), c); }\n\tpublic final Fps mulCompositeEquals(final Fps f, final long c)\
    \ {\n\t\tlong pow = 1;\n\t\tfor(int i = 0; i < f.a.length; i ++) { mulEquals(f,\
    \ i, pow); pow = md.mul(pow, c); }\n\t\treturn f;\n\t}\n\t// return f(x^d)\n\t\
    // O(N/d)\n\tpublic final Fps powComposite(final Fps f, final int d) { return\
    \ powComposite(f, d, Math.max(0, f.a.length * d - d + 1)); }\n\tpublic final Fps\
    \ powComposite(final Fps f, final int d, final int l) {\n\t\tSimpleUtil.nonNegativeCheck(d);\n\
    \t\tif(d == 0) return constant(eval(f, 1), f.a.length);\n\t\tFps g = zero(l);\n\
    \t\tfor(int i = 0, j = 0, m = Math.min(f.a.length, l / d + 1); i < m; i ++, j\
    \ += d) g.a[j] = f.a[i];\n\t\treturn g;\n\t}\n\tpublic final Fps powCompositeEquals(final\
    \ Fps f, final int d) { f.a = powComposite(f, d).a; return f; }\n\t// return f(1+cx^d)\n\
    \tpublic final Fps sparseComposite(final Fps f, final int d, final long c) { return\
    \ sparseComposite(f, d, c, Math.max(0, f.a.length * d - d + 1)); }\n\tpublic final\
    \ Fps sparseComposite(final Fps f, final int d, final long c, final int l) { return\
    \ powCompositeEquals(mulCompositeEquals(addComposite(f, 1, l), c), d); }\n\tpublic\
    \ final Fps sparseCompositeEquals(final Fps f, final int d, final long c) { f.a\
    \ = sparseComposite(f, d, c).a; return f; }\n}\n\nclass Fps implements Comparable<Fps>\
    \ {\n\tprivate final FpsOperator op;\n\tpublic long a[];\n\n\tFps(final FpsOperator\
    \ op, final int l) { SimpleUtil.nonNegativeCheck(l); this.op = op; a = new long[l];\
    \ }\n\tFps(final FpsOperator op, final int l, final long x) { this(op, l); Arrays.fill(a,\
    \ op.md.mod(x)); }\n\tFps(final FpsOperator op, final long[] a, final int l) {\
    \ this(op, l); System.arraycopy(a, 0, this.a, 0, Math.min(a.length, l)); }\n\t\
    Fps(final FpsOperator op, final long[] a) { this(op, a, a.length); }\n\tFps(final\
    \ FpsOperator op, final Fps g, final int l) { this(op, g.a, l); }\n\tFps(final\
    \ FpsOperator op, final Fps g) { this(op, g.a); }\n\tFps(final Fps g, final int\
    \ l) { this(g.op, g.a, l); }\n\tFps(final Fps g) { this(g.op, g.a); }\n\n\tpublic\
    \ int size() { return a.length; }\n\tpublic long[] get() { return a; }\n\tpublic\
    \ long get(final int i) { return i < a.length ? a[i] : 0; }\n\n\tpublic int lowest()\
    \ { for(int i = 0; i < a.length; i ++) if(a[i] != 0) return i; return a.length;\
    \ }\n\n\t@Override public String toString() { return Arrays.toString(a); }\n\t\
    @Override public int hashCode() { return Arrays.hashCode(a); }\n\t@Override\n\t\
    public boolean equals(final Object obj) {\n\t\tif(this == obj) return true;\n\t\
    \tif(obj == null) return false;\n\t\tif(this.getClass() != obj.getClass()) return\
    \ false;\n\t\tFps that = (Fps) obj;\n\t\tif(!Arrays.equals(a, that.a)) return\
    \ false;\n\t\treturn true;\n\t}\n\t@Override\n\tpublic int compareTo(final Fps\
    \ that) { return Arrays.compare(a, that.a); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/Mod.java
  - library/Convolution.java
  isVerificationFile: false
  path: library/Fps.java
  requiredBy: []
  timestamp: '2022-10-30 18:28:39+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - library/Fps_log_test.java
  - library/Fps_sqrt_test.java
  - library/Fps_exp_test.java
  - library/Fps_inv_test.java
  - library/Fps_mul_test.java
  - library/Fps_pow_test.java
documentation_of: library/Fps.java
layout: document
redirect_from:
- /library/library/Fps.java
- /library/library/Fps.java.html
title: library/Fps.java
---
