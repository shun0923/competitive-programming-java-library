---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix.java
    title: library/WaveletMatrix.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/CompressedWaveletMatrix_freq_test.java
    title: library/CompressedWaveletMatrix_freq_test.java
  - icon: ':heavy_check_mark:'
    path: library/CompressedWaveletMatrix_smallest_test.java
    title: library/CompressedWaveletMatrix_smallest_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':question:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/CompressedWaveletMatrix.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.WaveletMatrix;\n\nclass CompressedWaveletMatrix {\n\tint n;\n\tlong\
    \ val[];\n\tTreeMap<Long, Integer> tm = new TreeMap<>();\n\tWaveletMatrix wm;\n\
    \n\tCompressedWaveletMatrix(long[] a) {\n\t\tn = a.length;\n\t\tSet<Long> ts =\
    \ new TreeSet<>();\n\t\tfor(int i = 0; i < n; i ++) ts.add(a[i]);\n\t\tval = new\
    \ long[ts.size()];\n\t\tint j = 0;\n\t\tfor(long x : ts) { val[j] = x; tm.put(x,\
    \ j ++); }\n\t\tint a2[] = new int[n];\n\t\tfor(int i = 0; i < n; i ++) a2[i]\
    \ = tm.get(a[i]);\n\t\twm = new WaveletMatrix(a2);\n\t}\n\n\tfinal long get(int\
    \ k) { return val[wm.get(k)]; }\n\tfinal int rank(long x, int k) { return tm.containsKey(x)\
    \ ? wm.rank(tm.get(x), k) : 0; }\n\tfinal int rank(long x, int l, int r) { return\
    \ tm.containsKey(x) ? wm.rank(tm.get(x), l, r) : 0; }\n\tfinal int select(long\
    \ x, int k) { return tm.containsKey(x) ? wm.select(tm.get(x), k) : n; }\n\tfinal\
    \ long smallest(int l, int r, int k) { return val[wm.smallest(l, r, k)]; }\n\t\
    final long largest(int l, int r, int k) { return val[wm.largest(l, r, k)]; }\n\
    \tfinal int lessFreq(long x, int l, int r) { var e = tm.floorEntry(x); return\
    \ e == null ? 0 : wm.lessFreq(e.getValue(), l, r); }\n\tfinal int greaterFreq(long\
    \ x, int l, int r) { var e = tm.ceilingEntry(x); return e == null ? 0 : wm.greaterFreq(e.getValue(),\
    \ l, r); }\n\tfinal int rangeFreq(long lower, long upper, int l, int r) { return\
    \ lessFreq(upper, l, r) - lessFreq(lower, l, r); }\n\tfinal int freq(int x, int\
    \ l, int r) { return rank(x, r) - rank(x, l); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/WaveletMatrix.java
  isVerificationFile: false
  path: library/CompressedWaveletMatrix.java
  requiredBy: []
  timestamp: '2022-09-22 21:14:25+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - library/CompressedWaveletMatrix_freq_test.java
  - library/CompressedWaveletMatrix_smallest_test.java
documentation_of: library/CompressedWaveletMatrix.java
layout: document
redirect_from:
- /library/library/CompressedWaveletMatrix.java
- /library/library/CompressedWaveletMatrix.java.html
title: library/CompressedWaveletMatrix.java
---
