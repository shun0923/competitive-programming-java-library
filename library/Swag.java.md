---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Pair.java
    title: library/Pair.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Swag_test.java
    title: library/Swag_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Swag.java\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\nimport library.Pair;\n\nclass Swag {\n\tint n;\n\tlong\
    \ val[];\n\tlong e;\n\tLongBinaryOperator f;\n\n\tlong front;\n\tDeque<Long> back\
    \ = new ArrayDeque<>();\n\tint l = 0;\n\tint r = 0;\n\n\t// O(1)\n\tSwag(long[]\
    \ val, long e, LongBinaryOperator f) {\n\t\tn = val.length;\n\t\tthis.val = val;\n\
    \t\tthis.e = e;\n\t\tthis.f = f;\n\t\tfront = e;\n\t}\n\n\t// O(N + QlogQ)\n\t\
    long[] query(Pair.II[] p) {\n\t\tInteger idx[] = new Integer[p.length];\n\t\t\
    Arrays.sort(idx, (ele1, ele2) -> {\n\t\t\tint c = Integer.compare(p[ele1].a, p[ele2].a);\n\
    \t\t\tif(c == 0) c = Integer.compare(p[ele1].b, p[ele2].b);\n\t\t\tif(c == 0)\
    \ c = Integer.compare(ele1, ele2);\n\t\t\treturn c;\n\t\t});\n\t\tlong ans[] =\
    \ new long[p.length];\n\t\tfor(int i : idx) ans[i] = fold(p[i]);\n\t\treturn ans;\n\
    \t}\n\t// O(N + Q)\n\t// p is sorted\n\tlong[] sortedQuery(Pair.II[] p) {\n\t\t\
    long ans[] = new long[p.length];\n\t\tfor(int i = 0; i < p.length; i ++) ans[i]\
    \ = fold(p[i]);\n\t\treturn ans;\n\t}\n\n\t// return fold [i, j)\n\tlong fold(Pair.II\
    \ p) { return fold(p.a, p.b); }\n\tlong fold(int i, int j) {\n\t\tSimpleUtil.rangeCheck(i,\
    \ n);\n\t\tSimpleUtil.inclusiveRangeCheck(j, n);\n\t\tSimpleUtil.assertion(i >=\
    \ l && j >= r);\n\t\twhile(r < j) front = f.applyAsLong(front, val[r ++]);\n\t\
    \twhile(l < i) {\n\t\t\tif(back.isEmpty()) {\n\t\t\t\tlong tmp = e;\n\t\t\t\t\
    for(int u = r - 1; u >= l; u --) {\n\t\t\t\t\ttmp = f.applyAsLong(val[u], tmp);\n\
    \t\t\t\t\tback.addLast(tmp);\n\t\t\t\t}\n\t\t\t\tfront = e;\n\t\t\t}\n\t\t\tback.removeLast();\n\
    \t\t\tl ++;\n\t\t}\n\t\treturn back.isEmpty() ? front : f.applyAsLong(back.getLast(),\
    \ front);\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/Pair.java
  isVerificationFile: false
  path: library/Swag.java
  requiredBy: []
  timestamp: '2022-09-21 19:01:13+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Swag_test.java
documentation_of: library/Swag.java
layout: document
redirect_from:
- /library/library/Swag.java
- /library/library/Swag.java.html
title: library/Swag.java
---
