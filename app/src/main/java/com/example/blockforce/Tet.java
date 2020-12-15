package com.example.blockforce;

import android.util.Log;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Tet {
    private int[][] field = new int[][]{
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,0,0,0,0,0,0,0,0,0,0,0,0,99},
            {99,99,99,99,99,99,99,99,99,99,99,99,99,99},
    };

    public int[][] getField() {
        return field;
    }

    public int getCount() {
        return count;
    }

    public int getLevel() {
        return level;
    }

    public int getDelete_count() {
        return delete_count;
    }

    public int[][][] getNextForm(){
        int[][][] next = new int[4][][];
        next[0] = nextForm1;
        next[1] = nextForm2;
        next[2] = nextForm3;
        next[3] = specialForm;
        return next;
    }

    private int[][][] Default_block = new int[][][]{
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {1,1,1,1,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,2,2,2,0},
                    {0,2,0,0,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,3,3,3,0},
                    {0,0,0,3,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,4,4,0},
                    {0,4,4,0,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,5,5,0,0},
                    {0,0,5,5,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,6,6,0,0},
                    {0,6,6,0,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,7,7,7,0},
                    {0,0,7,0,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,8},
                    {8,8,8,8,8},
                    {0,0,0,0,8},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {8,8,8,8,0},
                    {8,8,8,8,0},
                    {8,8,8,8,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {8,8,8,8,8},
                    {8,0,8,0,8},
                    {8,0,8,0,8}
            },
            {
                    {0,0,0,0,0},
                    {8,8,0,8,8},
                    {0,8,8,8,0},
                    {8,8,0,8,8},
                    {0,0,0,0,0}
            },
            //変更なし
            {
                    {0,0,0,0,0},
                    {0,8,0,8,0},
                    {0,0,8,0,0},
                    {0,8,0,8,0},
                    {0,0,0,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,8,0,0},
                    {8,8,8,8,8},
                    {0,8,0,8,0}
            },
            {
                    {0,0,0,0,0},
                    {0,8,0,8,0},
                    {8,8,8,8,8},
                    {0,8,0,8,0},
                    {0,0,0,0,0}
            },
    };

    private int[][] currentForm = new int[5][5];
    private int currentX,currentY;
    private int[][] nextForm1 = new int [5][5];
    private int[][] nextForm2 = new int [5][5];
    private int[][] nextForm3 = new int [5][5];
    private int[][] specialForm = new int [5][5];
    private int count = 0;
    private int level = 1;
    private int delete_count = 0;
    private int check_delete_count = 0;

    //最初の初期化，次，その次，さらに次のブロックも格納
    public void init(){
        try{
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            nextForm1=Default_block[random.nextInt(7)+1];
            nextForm2=Default_block[random.nextInt(7)+1];
            nextForm3=Default_block[random.nextInt(7)+1];
            currentForm=Default_block[random.nextInt(7)+1];
            specialForm=Default_block[random.nextInt(7)+8];
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        currentX = 3;
        currentY = 7;
        count = 20;
        reflection(currentForm, currentX, currentY,TRUE);
        underLocation();
    }

    //選択してるブロックtarget(5×5)をfieldのx,yの位置に反映する,反映できたらTRUE，反映する場所に何かしらのブロックがあればFALSE
    public boolean reflection(int[][] target, int x, int y , boolean sw){
        int[][] temp = new int[26][14];
        for(int i = 0; i < temp.length; i++){
            System.arraycopy(field[i], 0, temp[i], 0, temp[i].length);
        }
        for(int i = -2; i < 3; i++){
            for(int j = -2; j < 3; j++){
                if(target[i + 2][j + 2] != 0){
                    if(y + j >= 0 && y + j <= 13){
                        if(field[x + i][y + j] > 0){
                            field = temp;
                            return FALSE;
                        }
                    }else{
                        field = temp;
                        return FALSE;
                    }
                    field[x + i][y + j] = target[i + 2][j + 2];
                }
            }
        }
        if(!sw){
            field = temp;
        }
        return TRUE;
    }

    //新しいブロックを生成(nextFormをfieldに生成してnextFormをずらして3番目をランダムに生成) and 生成できるかどうか(ゲームオーバーかどうかの判定)
    public boolean newBlock(){
        currentForm = nextForm1;
        nextForm1 = nextForm2;
        nextForm2 = nextForm3;
        if(count == 4){
            nextForm3 = specialForm;
            try{
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                specialForm = Default_block[random.nextInt(7) + 8];
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            count = 20;
        }else{
            try{
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                nextForm3 = Default_block[random.nextInt(7) + 1];
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            count--;
        }
        currentX = 3;
        currentY = 7;
        if(!reflection(currentForm, currentX, currentY,TRUE)){
            Log.d("gameover","gameover");
            return TRUE;
        }
        underLocation();
        return FALSE;
    }

    //現在のブロックを一段下に下げる and 下げ切ったのなら行を削除するかを確認してnewblock()呼び出し
    public boolean update(){
        DrawDelete(currentForm, currentX, currentY);
        currentX++;
        if(!reflection(currentForm, currentX, currentY, TRUE)) {
            //下げ切った場合
            currentX--;
            reflection(currentForm, currentX, currentY, TRUE);
            DeleteCheck();
            if(newBlock()){
                return FALSE;
            }
        }
        underLocation();
        return TRUE;
    }

    //行を削除するかを確認,揃ってる行があれば削除
    public void DeleteCheck(){
        for(int i = field.length - 2; i > 2; i--){
            boolean judge = TRUE;
            for(int j = 0; j < field[i].length; j++){
                if(field[i][j] == 0) {
                    judge = FALSE;
                    break;
                }
            }
            if(judge) {
                delete_count++;
                for(int k = i; k > 2; k--){
                    System.arraycopy(field[k - 1], 0, field[k], 0, field[k].length);
                }
                i++;
            }
            if(delete_count - check_delete_count == 10){
                check_delete_count = delete_count;
                level++;
            }
        }
    }

    //指定したブロックをfieldから削除
    public void DrawDelete(int[][] target, int x, int y){
        for(int i = -2; i < 3; i++){
            for(int j = -2; j < 3; j++){
                if(target[i + 2][j + 2] != 0){
                    field[x + i][y + j] = 0;
                }
            }
        }
    }

    //左右移動の処理
    public void move(boolean LR){
        DrawDelete(currentForm, currentX, currentY);
        if(LR){
            currentY++;
        }else{
            currentY--;
        }
        if(!reflection(currentForm,currentX,currentY,TRUE)) {
            if(LR){
                currentY--;
            }else{
                currentY++;
            }
            reflection(currentForm,currentX,currentY,TRUE);
        }
        underLocation();
    }

    //下瞬間移動した場合の位置をfieldに反映(このままいけばここに落ちるよ！っていう位置としてfieldに-1を入れる)
    public void underLocation(){
        int[][] shadow = new int[5][5];
        for(int m = 0; m < currentForm.length; m++){
            for(int n = 0; n < currentForm[m].length; n++){
                if(currentForm[m][n] > 0){
                    shadow[m][n] = -1;
                }
            }
        }
        underComp(shadow);
        reflection(currentForm, currentX, currentY, TRUE);
    }

    //下瞬間移動のボタンを押した場合の処理
    public boolean under(){
        underComp(currentForm);
        DeleteCheck();
        if(newBlock()){
            return TRUE;
        }
        return FALSE;
    }

    public void underComp(int[][] comp){
        DrawDelete(currentForm, currentX, currentY);
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                if(field[i][j] == -1){
                    field[i][j] = 0;
                }
            }
        }
        int x = currentX;
        for(;;){
            x++;
            if(!reflection(comp, x, currentY,FALSE)){
                x--;
                reflection(comp,x,currentY,TRUE);
                break;
            }
        }
    }

    //回転の処理,LR=trueなら右，falseなら左
    public void rotation(boolean LR){
        if(currentForm[2][2] == 6 || currentForm[2][2] == 12){
           return;
        }
        int[][] newBlock = new int[5][5];
        for(int i = 0; i < currentForm.length; i++){
            for(int j = currentForm.length-1; j >= 0; j--){
                newBlock[i][j] = currentForm[j][i];
            }
        }
        if(LR){
            int temp;
            for(int k = 0; k < 5; k++){
                for(int i = 0, j = 4; i < 2; i++, j--){
                    temp = newBlock[k][i];
                    newBlock[k][i] = newBlock[k][j];
                    newBlock[k][j] = temp;
                }
            }
        }else{
            int[] temp;
            for(int i = 0, j = 4; i < 2; i++, j--){
                temp = newBlock[i];
                newBlock[i] = newBlock[j];
                newBlock[j] = temp;
            }
        }
        DrawDelete(currentForm, currentX, currentY);

        int [] seq = {0,1,-1,2,-2};
        for (int value : seq) {
            if (reflection(newBlock, currentX, (currentY + value), TRUE)) {
                currentY += value;
                currentForm = newBlock;
                underLocation();
                return;
            }
        }
        reflection(currentForm, currentX, currentY,TRUE);
        underLocation();
    }
}