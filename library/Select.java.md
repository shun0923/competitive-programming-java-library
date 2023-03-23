---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
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
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nclass\
    \ QuickSelect {\n\t// O(N)\n\t// return k-th(0-indexed) smallest\n\tpublic static\
    \ final long selectWithRandom(long[] a, int k) {\n\t\twhile(true) {\n\t\t\tlong\
    \ pivot = a[(int)Math.floor(Math.random() * a.length)];\n\t\t\tint small = 0;\n\
    \t\t\tint equal = 0;\n\t\t\tint large = 0;\n\t\t\tfor(long crt : a) {\n\t\t\t\t\
    if(crt < pivot) small ++;\n\t\t\t\telse if(crt > pivot) large ++;\n\t\t\t\telse\
    \ equal ++;\n\t\t\t}\n\t\t\tif(k < small) {\n\t\t\t\tlong a2[] = new long[small];\n\
    \t\t\t\tint idx = 0;\n\t\t\t\tfor(long crt : a) if(crt < pivot) a2[idx ++] = crt;\n\
    \t\t\t\ta = a2;\n\t\t\t}else if(k >= small + equal) {\n\t\t\t\tlong a2[] = new\
    \ long[large];\n\t\t\t\tint idx = 0;\n\t\t\t\tfor(long crt : a) if(crt > pivot)\
    \ a2[idx ++] = crt;\n\t\t\t\ta = a2;\n\t\t\t\tk -= small + equal;\n\t\t\t}else\
    \ {\n\t\t\t\treturn pivot;\n\t\t\t}\n\t\t}\n\t}\n\tpublic static final long select(final\
    \ long[] a, final int k) { return select(a, k, 0, a.length); }\n\tpublic static\
    \ final long select(final long[] a, final int k, int start, int end) {\n\t\tSimpleUtil.assertion(start\
    \ <= k && k < end);\n\t\tif(end - start == 1) return a[start];\n\t\tif(end - start\
    \ <= 10) {\n\t\t\tArrays.sort(a, start, end);\n\t\t\treturn a[k];\n\t\t}\n\t\t\
    while(true) {\n\t\t\tlong pivot = pivot(a, start, end);\n\t\t\tint l = start;\n\
    \t\t\tint r = end;\n\t\t\tlong tmp[] = new long[end - start];\n\t\t\tArrays.fill(tmp,\
    \ pivot);\n\t\t\tfor(int i = start; i < end; i ++) {\n\t\t\t\tif(a[i] < pivot)\
    \ tmp[(l ++) - start] = a[i];\n\t\t\t\telse if(a[i] > pivot) tmp[(-- r) - start]\
    \ = a[i];\n\t\t\t}\n\t\t\tfor(int i = start; i < end; i ++) a[i] = tmp[i - start];\n\
    \t\t\tif(r <= k) start = r;\n\t\t\telse if(l > k) end = l;\n\t\t\telse return\
    \ a[k];\n\t\t}\n\t}\n\tprivate static final long pivot(final long[] a, final int\
    \ start, final int end) {\n\t\tlong med[] = new long[(end - start + 4) / 5];\n\
    \t\tfor(int l = start, j = 0; l < end; l += 5, j ++) med[j] = med5(a, l, Math.min(l\
    \ + 5, end));\n\t\tif(med.length == 1) return med[0];\n\t\treturn select(med,\
    \ med.length >> 1);\n\t}\n\tprivate static final long med5(final long[] a, final\
    \ int start, final int end) {\n\t\treturn select(a, (end + start) >> 1, start,\
    \ end);\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/Select.java
  requiredBy: []
  timestamp: '2022-11-02 13:03:31+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/Select.java
layout: document
redirect_from:
- /library/library/Select.java
- /library/library/Select.java.html
title: library/Select.java
---
