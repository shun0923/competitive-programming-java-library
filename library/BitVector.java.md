---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix.java
    title: library/WaveletMatrix.java
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
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
  code: "package library;\n\nimport library.SimpleUtil;\n\nclass BitVector {\n\tfinal\
    \ int lg = 5;\n\tfinal int bitSize = 1 << lg;\n\tfinal int mask = bitSize - 1;\n\
    \tfinal int n;\n\tfinal int len;\n\tint bit[];\n\tint sum[];\n\tint head0[];\n\
    \tint head1[];\n\tint pos0[];\n\tint pos1[];\n\n\t// O(1)\n\tBitVector(int n)\
    \ {\n\t\tthis.n = n;\n\t\tlen = (n >> lg) + 1;\n\t\tbit = new int[len];\n\t\t\
    sum = new int[len + 1];\n\t\tpos0 = new int[len];\n\t\tpos1 = new int[len];\n\t\
    }\n\n\t// O(N)\n\tfinal void init(boolean b[]) {\n\t\tfor(int i = 0, j = 0; i\
    \ < b.length; i += bitSize, j ++) {\n\t\t\tbit[j] = 0;\n\t\t\tfor(int i2 = Math.min(b.length,\
    \ i + bitSize) - 1; i2 >= i; i2 --) {\n\t\t\t\tbit[j] <<= 1;\n\t\t\t\tif(b[i2])\
    \ bit[j] |= 1;\n\t\t\t}\n\t\t}\n\t\tinit();\n\t}\n\tfinal void init() {\n\t\t\
    sum[0] = 0;\n\t\tfor(int i = 0; i < len; i ++) sum[i + 1] = sum[i] + Integer.bitCount(bit[i]);\n\
    \n\t\t{\n\t\t\tint size = 0;\n\t\t\tfor(int i = 0, cnt = 0; i < n; i ++) if(get(i)\
    \ && ((cnt ++) & mask) == 0) size ++;\n\t\t\thead1 = new int[++ size];\n\t\t\t\
    size = 0;\n\t\t\tfor(int i = 0, cnt = 0; i < n; i ++) if(get(i) && ((cnt ++) &\
    \ mask) == 0) head1[size ++] = i;\n\t\t\thead1[size] = n;\n\t\t\tfor(int i = 0;\
    \ i < size; i ++) {\n\t\t\t\tint l = head1[i] >> lg;\n\t\t\t\tif((head1[i + 1]\
    \ + mask >> lg) - l > bitSize) {\n\t\t\t\t\tfor(int j = head1[i], idx = 0; j <\
    \ head1[i + 1]; j ++) if(get(j)) pos1[l + (idx ++)] = j;\n\t\t\t\t}\n\t\t\t}\n\
    \t\t}\n\t\t{\n\t\t\tint size = 0;\n\t\t\tfor(int i = 0, cnt = 0; i < n; i ++)\
    \ if(!get(i) && ((cnt ++) & mask) == 0) size ++;\n\t\t\thead0 = new int[++ size];\n\
    \t\t\tsize = 0;\n\t\t\tfor(int i = 0, cnt = 0; i < n; i ++) if(!get(i) && ((cnt\
    \ ++) & mask) == 0) head0[size ++] = i;\n\t\t\thead0[size] = n;\n\t\t\tfor(int\
    \ i = 0; i < size; i ++) {\n\t\t\t\tint l = head0[i] >> lg;\n\t\t\t\tif((head0[i\
    \ + 1] + mask >> lg) - l > bitSize) {\n\t\t\t\t\tfor(int j = head0[i], idx = 0;\
    \ j < head0[i + 1]; j ++) if(!get(j)) pos0[l + (idx ++)] = j;\n\t\t\t\t}\n\t\t\
    \t}\n\t\t}\n\t}\n\n\tStringBuilder sb = new StringBuilder();\n\t// O(N)\n\t@Override\
    \ public String toString() {\n\t\tsb.setLength(0);\n\t\tfor(int i = 0; i < n;\
    \ i ++) sb.append(get(i) ? \"#\" : \":\");\n\t\treturn sb.toString();\n\t}\n\n\
    \t// O(1)\n\tfinal boolean get(int k) { SimpleUtil.rangeCheck(k, n); return (bit[k\
    \ >> lg] >> (k & mask) & 1) != 0; }\n\n\t// O(1)\n\tfinal void set(int k) { set(true,\
    \ k); }\n\tfinal void set(boolean b, int k) { SimpleUtil.rangeCheck(k, n); if(b)\
    \ bit[k >> lg] |= 1 << (k & mask); else bit[k >> lg] &= ~(1 << (k & mask)); }\n\
    \n\t// O(loglogN)\n\t// count b in [0, k)\n\tfinal int rank(int k) { SimpleUtil.inclusiveRangeCheck(k,\
    \ n); return sum[k >> lg] + Integer.bitCount(bit[k >> lg] & ((1 << (k & mask))\
    \ - 1)); }\n\tfinal int rank(boolean b, int k) { return b ? rank(k) : k - rank(k);\
    \ }\n\n\t// O(loglogN)\n\t// position of k-th occurrence of b\n\tfinal int select(int\
    \ k) { return select(true, k); }\n\tfinal int select(boolean b, int k) {\n\t\t\
    if(k >= (b ? sum[len] : n - sum[len])) return n;\n\t\tint l = (b ? head1 : head0)[k\
    \ >> lg] >> lg;\n\t\tint r = (b ? head1 : head0)[(k >> lg) + 1] + mask >> lg;\n\
    \t\tif(r - l > bitSize) return (b ? pos1 : pos0)[l + (k & mask)];\n\t\twhile(r\
    \ - l != 1) {\n\t\t\tint m = (l + r) >> 1;\n\t\t\tif((b ? sum[m] : (m << lg) -\
    \ sum[m]) <= k) l = m; else r = m;\n\t\t}\n\t\treturn (l << lg) + (b ? select32(bit[l],\
    \ k - sum[l]) : select32(~bit[l], k + sum[l] - (l << lg)));\n\t}\n\tfinal int\
    \ select32(int c, int k) {\n\t\tk ++;\n\t\tint c2 = (c & 0x55555555) + (c >> 1\
    \ & 0x55555555);\n\t\tint c4 = (c2 & 0x33333333) + (c2 >> 2 & 0x33333333);\n\t\
    \tint c8 = (c4 + (c4 >> 4)) & 0x0F0F0F0F;\n\t\tint c16 = (c8 + (c8 >> 8)) & 0x000000FF;\n\
    \t\tint idx = 0;\n\t\tidx |= ((c16 - k) & 128) >> 3;\n\t\tk -= c16 & ((c16 - k)\
    \ >> 7);\n\t\tc8 = c8 >> idx & 0xf;\n\t\tidx |= ((c8 - k) & 128) >> 4;\n\t\tk\
    \ -= c8 & ((c8 - k) >> 7);\n\t\tc4 = c4 >> idx & 0x7;\n\t\tidx |= ((c4 - k) &\
    \ 128) >> 5;\n\t\tk -= c4 & ((c4 - k) >> 7);\n\t\tc2 = c2 >> idx & 0x3;\n\t\t\
    idx |= ((c2 - k) & 128) >> 6;\n\t\tk -= c2 & ((c2 - k) >> 7);\n\t\tidx |= (((c\
    \ >> idx & 0x1) - k) & 128) >> 7;\n\t\treturn idx;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/BitVector.java
  requiredBy:
  - library/WaveletMatrix.java
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/BitVector.java
layout: document
redirect_from:
- /library/library/BitVector.java
- /library/library/BitVector.java.html
title: library/BitVector.java
---
