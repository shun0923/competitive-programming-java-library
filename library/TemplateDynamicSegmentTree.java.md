---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSegmentTree_small_test.java
    title: library/TemplateDynamicSegmentTree_small_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSegmentTree_test.java
    title: library/TemplateDynamicSegmentTree_test.java
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
  code: "package library;\n\nimport java.util.function.*;\nimport library.SimpleUtil;\n\
    \nclass TemplateDynamicSegmentTree<T> {\n\tclass NodeST {\n\t\tT val;\n\t\tNodeST\
    \ l = null;\n\t\tNodeST r = null;\n\t\tNodeST() { val = eSupplier.get(); }\n\t\
    \tNodeST(T val) { this.val = val; }\n\t}\n\n\tlong n;\n\tSupplier<T> eSupplier;\n\
    \tT e;\n\tBinaryOperator<T> f;\n\n\tNodeST root;\n\n\t// O(1)\n\tTemplateDynamicSegmentTree(long\
    \ len, Supplier<T> eSupplier, BinaryOperator<T> f) {\n\t\tSimpleUtil.nonNegativeCheck(len);\n\
    \t\tthis.n = len; this.eSupplier = eSupplier; this.e = eSupplier.get(); this.f\
    \ = f;\n\t\troot = new NodeST();\n\t}\n\n\t// O(logN)\n\tvoid set(long i, T val)\
    \ { SimpleUtil.rangeCheck(i, n); update(i, val, false); }\n\tvoid update(long\
    \ i, T val) { SimpleUtil.rangeCheck(i, n); update(i, val, true); }\n\tvoid update(long\
    \ i, T val, boolean update) { update(root, 0, n, i, val, update); }\n\tNodeST\
    \ update(NodeST t, long l, long r, long i, T val, boolean update) {\n\t\tif(t\
    \ == null) t = new NodeST();\n\t\tif(r - l == 1) { t.val = update ? f.apply(t.val,\
    \ val) : val; return t; }\n\t\tlong mid = (l + r) >> 1;\n\t\tif(i < mid) t.l =\
    \ update(t.l, l, mid, i, val, update);\n\t\telse t.r = update(t.r, mid, r, i,\
    \ val, update);\n\t\tt.val = eSupplier.get();\n\t\tif(t.l != null) t.val = f.apply(t.val,\
    \ t.l.val);\n\t\tif(t.r != null) t.val = f.apply(t.val, t.r.val);\n\t\treturn\
    \ t;\n\t}\n\n\t// O(logN)\n\tT get(long i) { SimpleUtil.rangeCheck(i, n); return\
    \ get(root, 0, n, i); }\n\tT get(NodeST t, long l, long r, long i) {\n\t\tif(t\
    \ == null) return e;\n\t\tif(r - l == 1) return t.val;\n\t\tlong mid = (l + r)\
    \ >> 1;\n\t\treturn i < mid ? get(t.l, l, mid, i) : get(t.r, mid, r, i);\n\t}\n\
    \tT find(long l0, long r0) {\n\t\tSimpleUtil.inclusiveRangeCheck(l0, n);\n\t\t\
    SimpleUtil.inclusiveRangeCheck(r0, n);\n\t\tSimpleUtil.assertion(l0 <= r0, \"\
    l is larger than r.\");\n\t\treturn find(root, 0, n, l0, r0);\n\t}\n\tT find(NodeST\
    \ t, long l, long r, long l0, long r0) {\n\t\tif(l == r || t == null || r0 <=\
    \ l || r <= l0) return e;\n\t\tif(l0 <= l && r <= r0) return t.val;\n\t\tlong\
    \ mid = (l + r) >> 1;\n\t\treturn f.apply(find(t.l, l, mid, l0, r0), find(t.r,\
    \ mid, r, l0, r0));\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/TemplateDynamicSegmentTree.java
  requiredBy: []
  timestamp: '2023-03-23 19:02:13+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateDynamicSegmentTree_small_test.java
  - library/TemplateDynamicSegmentTree_test.java
documentation_of: library/TemplateDynamicSegmentTree.java
layout: document
redirect_from:
- /library/library/TemplateDynamicSegmentTree.java
- /library/library/TemplateDynamicSegmentTree.java.html
title: library/TemplateDynamicSegmentTree.java
---
